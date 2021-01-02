package javaanpr.imageanalysis;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javaanpr.intelligence.Intelligence;

public class PlateGraph extends Graph {
    
        Plate handle;
        
        private static double plategraph_rel_minpeaksize =
                Intelligence.configurator.getDoubleProperty("plategraph_rel_minpeaksize");
        private static double peakFootConstant =
                Intelligence.configurator.getDoubleProperty("plategraph_peakfootconstant");
        
        public PlateGraph(Plate handle) {
            this.handle = handle;
        }
        
        public class SpaceComparer implements Comparator {
            Vector<Float> yValues = null;
            
            public SpaceComparer(Vector<Float> yValues) {
                this.yValues = yValues;
            }
            
            private float getPeakValue(Object peak) {
                return ((Peak)peak).getCenter(); // left > right
                //return this.yValues.elementAt( ((Peak)peak).center()  );
            }
            
            public int compare(Object peak1, Object peak2) { 
                double comparison = this.getPeakValue(peak2) - this.getPeakValue(peak1);
                if (comparison < 0) return 1;
                if (comparison > 0) return -1;
                return 0;
            }
        }
        
        public Vector<Peak> findPeaks(int count) {
            Vector<Peak> spacesTemp = new Vector<Peak>(); 
            //  diffVal = average - (maxval - average) = 2average - maxval
            //  val -= diffVal
            float diffGVal = 2 * this.getAverageValue() - this.getMaxValue();
            
            Vector<Float> yValuesNew = new Vector<Float>();
            for (Float f : this.yValues) {
                yValuesNew.add(f.floatValue()-diffGVal);
            }
            this.yValues = yValuesNew;
            
            this.deActualizeFlags();
            // end
            
            for (int c=0; c<count; c++) { // for count
                float maxValue = 0.0f;
                int maxIndex = 0;
                for (int i=0; i<this.yValues.size(); i++) { // zlava doprava
                    if (allowedInterval(spacesTemp, i)) { // ak potencialny vrchol sa nachadza vo "volnom" intervale, ktory nespada pod ine vrcholy
                        if (this.yValues.elementAt(i) >= maxValue) {
                            maxValue = this.yValues.elementAt(i);
                            maxIndex = i;
                        }
                    }
                } // end for int 0->max
             if (yValues.elementAt(maxIndex) < plategraph_rel_minpeaksize * this.getMaxValue()) break;                
                int leftIndex = indexOfLeftPeakRel(maxIndex, peakFootConstant); 
                int rightIndex = indexOfRightPeakRel(maxIndex, peakFootConstant);
                
                spacesTemp.add(new Peak(
                        Math.max(0,leftIndex),
                        maxIndex,
                        Math.min(this.yValues.size()-1,rightIndex)
                        ));
            } // end for count
            Vector<Peak> spaces = new Vector<Peak>();
            for (Peak p : spacesTemp) {
                if (p.getDiff() < 1 * this.handle.getHeight() 
                    ) spaces.add(p);
                    //else outPeaksFiltered.add(p);
            }
            
                     Collections.sort(spaces, (Comparator<? super Graph.Peak>)
                                     new SpaceComparer(this.yValues));
            Vector<Peak> chars = new Vector<Peak>();
            if (spaces.size()!=0) {

                int minIndex = this.getMinValueIndex(0,spaces.elementAt(0).getCenter());
                int leftIndex = 0;     
                Peak first = new Peak(leftIndex,spaces.elementAt(0).getCenter());
                if (first.getDiff()>0) chars.add(first);
            }
            
            for (int i=0; i<spaces.size() - 1; i++) {
                int left = spaces.elementAt(i).getCenter();
                int right = spaces.elementAt(i+1).getCenter();
                chars.add(new Peak(left,right));
            } 
            if (spaces.size()!=0) {
                Peak last = new Peak(
                    spaces.elementAt(spaces.size()-1).getCenter(),
                    this.yValues.size()-1
                        );
                if (last.getDiff()>0) chars.add(last);
            }
            super.peaks = chars;
            return chars;
        }                
}
