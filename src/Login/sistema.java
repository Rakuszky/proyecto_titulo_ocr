package Login;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class sistema extends javax.swing.JFrame {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    } ///agregado

    //DEFINICIONES NUEVAS
    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture captura = null;
    
    //Variables de prueba
    
    String patente_prueba = "LPYY50";

    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    String output = "D:\\image.jpg";

    //Clase Daemon
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (captura.isOpened()) {
                        while (true) {
                            captura.read(frame);
                            if (!frame.empty()) {
                                setSize(frame.width() +50, frame.height() + 70);

                                Mat imagemColorida = frame;
                                Mat imagenGris = new Mat();
                                Imgproc.cvtColor(imagemColorida, imagenGris, COLOR_BGR2GRAY);
                                String base = "C:\\Program Files\\opencv\\sources\\data\\haarcascades";
                                CascadeClassifier classificador
                                        = new CascadeClassifier(base + "\\haarcascade_russian_plate_number.xml");
                                MatOfRect facesDetectadas = new MatOfRect();
                                classificador.detectMultiScale(imagenGris, facesDetectadas);                              

                                for (Rect rect : facesDetectadas.toArray()) {
                                    Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
                                            new Point(rect.x + rect.width, rect.y + rect.height),
                                            new Scalar(0, 255, 255), 2);
                                    Imgcodecs.imwrite(output, imagemColorida);
                                    
                                }

                                BufferedImage imagem = new utilidad().convertMatToImage(frame);
                                Graphics g = panelVideo.getGraphics();
                                g.drawImage(imagem, 0, 0, imagem.getWidth(), imagem.getHeight(), null);
                            }
                        }
                    }
                }
            }
        }
    }

    public sistema() {
        initComponents();
        etiquetaPatenteSistemaBuscar.setText(patente_prueba);  //Variable de prueba
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDatos = new javax.swing.JPanel();
        etiquetaPatenteSistema = new javax.swing.JLabel();
        etiquetaPatenteSistemaBuscar = new javax.swing.JLabel();
        etiquetaNombreSistema = new javax.swing.JLabel();
        etiquetaApellidoSistema = new javax.swing.JLabel();
        etiquetaBlockSistema = new javax.swing.JLabel();
        etiquetaDepartamentoSistema = new javax.swing.JLabel();
        etiquetaEstacionamientoSistema = new javax.swing.JLabel();
        etiquetaTelefonoSistema1 = new javax.swing.JLabel();
        etiquetaRunSistema = new javax.swing.JLabel();
        etiquetaRunSistema2 = new javax.swing.JLabel();
        etiquetaRunSistema3 = new javax.swing.JLabel();
        etiquetaRunSistema4 = new javax.swing.JLabel();
        etiquetaRunSistema5 = new javax.swing.JLabel();
        etiquetaRunSistema6 = new javax.swing.JLabel();
        etiquetaRunSistema7 = new javax.swing.JLabel();
        etiquetaRunSistema8 = new javax.swing.JLabel();
        panelVideo = new javax.swing.JPanel();
        iniciarVideo = new javax.swing.JButton();
        pausarVideo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Control Vehicular");
        setMaximumSize(new java.awt.Dimension(830, 570));
        setMinimumSize(new java.awt.Dimension(830, 570));
        setPreferredSize(new java.awt.Dimension(830, 570));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etiquetaPatenteSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaPatenteSistema.setText("Patente");
        panelDatos.add(etiquetaPatenteSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        etiquetaPatenteSistemaBuscar.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaPatenteSistemaBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaPatenteSistemaBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaPatenteSistemaBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 130, 30));

        etiquetaNombreSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaNombreSistema.setText("Nombre:");
        panelDatos.add(etiquetaNombreSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        etiquetaApellidoSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaApellidoSistema.setText("Apellido:");
        panelDatos.add(etiquetaApellidoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        etiquetaBlockSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaBlockSistema.setText("Block:");
        panelDatos.add(etiquetaBlockSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        etiquetaDepartamentoSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaDepartamentoSistema.setText("Departamento:");
        panelDatos.add(etiquetaDepartamentoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        etiquetaEstacionamientoSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaEstacionamientoSistema.setText("Estacionamiento:");
        panelDatos.add(etiquetaEstacionamientoSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        etiquetaTelefonoSistema1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaTelefonoSistema1.setText("Telefono:");
        panelDatos.add(etiquetaTelefonoSistema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        etiquetaRunSistema.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        etiquetaRunSistema.setText("RUN:");
        panelDatos.add(etiquetaRunSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        etiquetaRunSistema2.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 20));

        etiquetaRunSistema3.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 130, 20));

        etiquetaRunSistema4.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 130, 20));

        etiquetaRunSistema5.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 150, 20));

        etiquetaRunSistema6.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 80, 20));

        etiquetaRunSistema7.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 60, 20));

        etiquetaRunSistema8.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        etiquetaRunSistema8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDatos.add(etiquetaRunSistema8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 130, 20));

        getContentPane().add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 231, 360));

        panelVideo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelVideo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panelVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 10, 560, 450));

        iniciarVideo.setText("Iniciar");
        iniciarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarVideoActionPerformed(evt);
            }
        });
        getContentPane().add(iniciarVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        pausarVideo.setText("Salir del Sistema");
        pausarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarVideoActionPerformed(evt);
            }
        });
        getContentPane().add(pausarVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, -1));

        jMenu1.setText("Archivo");

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem1.setText("Añadir Propietarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Acerca de");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void iniciarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarVideoActionPerformed
        captura = new VideoCapture(2);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        iniciarVideo.setEnabled(false);  //start button
        pausarVideo.setEnabled(true);  // stop button
    }//GEN-LAST:event_iniciarVideoActionPerformed

    private void pausarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarVideoActionPerformed
        
        btnSalir();
        
    }//GEN-LAST:event_pausarVideoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        agregarPropietarios form2 = new agregarPropietarios();
                    form2.setVisible(true);
                    //this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new sistema().setVisible(true);
        });

    }
    
    public void btnSalir(){
        if(!iniciarVideo.isEnabled()){
            myThread.runnable = false;
            pausarVideo.setEnabled(true);
            iniciarVideo.setEnabled(false);
            captura.release();
            System.exit(0);
        } else {
            System.exit(0);
        }
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaApellidoSistema;
    private javax.swing.JLabel etiquetaBlockSistema;
    private javax.swing.JLabel etiquetaDepartamentoSistema;
    private javax.swing.JLabel etiquetaEstacionamientoSistema;
    private javax.swing.JLabel etiquetaNombreSistema;
    private javax.swing.JLabel etiquetaPatenteSistema;
    private javax.swing.JLabel etiquetaPatenteSistemaBuscar;
    private javax.swing.JLabel etiquetaRunSistema;
    private javax.swing.JLabel etiquetaRunSistema2;
    private javax.swing.JLabel etiquetaRunSistema3;
    private javax.swing.JLabel etiquetaRunSistema4;
    private javax.swing.JLabel etiquetaRunSistema5;
    private javax.swing.JLabel etiquetaRunSistema6;
    private javax.swing.JLabel etiquetaRunSistema7;
    private javax.swing.JLabel etiquetaRunSistema8;
    private javax.swing.JLabel etiquetaTelefonoSistema1;
    private javax.swing.JButton iniciarVideo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelVideo;
    private javax.swing.JButton pausarVideo;
    // End of variables declaration//GEN-END:variables
}
