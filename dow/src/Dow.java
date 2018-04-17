import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DT on 2017/11/6.
 */
public class Dow extends JFrame {
    //提示的lable
    private JLabel jLabel = new JLabel ();
    //获得的路径
    private String path;
    //输入作业编号的Text的文本框
    private static JTextField jTextField = new JTextField (10);
    //选择存放路径
    private JButton selectJb = new JButton ("选择存放路径");
    private JPanel jp;
    //下载的按钮
    private JButton dowButton = new JButton ("点击下载");
    ;
    private String twid;

    public static void main(String[] args) {
        new Dow ().init ();
    }

    public void init() {
        this.setSize (400, 300);
        this.setLocationRelativeTo (this.getOwner ());//居中屏幕显示
        dowButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Dow.this.path == null || Dow.this.path == "") {
                    JOptionPane.showMessageDialog (null, "请选择存放路径", "出错", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                //获得的作业编号
                String twid = Dow.this.jTextField.getText ();
                if (twid == null || twid == "") {
                    JOptionPane.showMessageDialog (null, "请输入作业编号", "出错", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!twid.matches ("[0-9]{1,10}")) {
                    JOptionPane.showMessageDialog (null, "作业编号只能是数字", "出错", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Dow.this.dowButton.setText ("正在下载");
                try {
                    Thread.sleep (100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace ();
                }
                Dow.this.dowButton.setEnabled (false);
                new Dow ().run (twid, Dow.this.path);
                Dow.this.dowButton.setText ("点击下载");
                Dow.this.dowButton.setEnabled (true);
                JOptionPane.showMessageDialog (null, "下载完成", "完成", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        selectJb.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jc = new JFileChooser ();
                    jc.setFileSelectionMode (JFileChooser.DIRECTORIES_ONLY);
                    jc.showOpenDialog (null);
                    File f = jc.getSelectedFile ();
                    if (!f.isDirectory ()) {
                        Dow.this.jLabel.setText ("请选择一个文件夹");
                    } else {
                        Dow.this.path = f.getCanonicalPath () + "/";
                        Dow.this.jLabel.setText (f.getCanonicalPath ());
                    }
                } catch (IOException e1) {
                    e1.printStackTrace ();
                }

            }
        });
        jp = new JPanel ();
        jp.add (selectJb);
        jp.add (this.jLabel);
        JLabel jLabel = new JLabel ("请输入作业编号在我的作业里面点击某一个作业上面有作业编号");
        jp.add (jLabel);
        jp.add (jTextField);
        jp.add (dowButton);
        this.add (jp);
        this.setVisible (true);
        this.setDefaultCloseOperation (this.EXIT_ON_CLOSE);
    }

    private void run(String twid, String Filepath) {
        try {
            URL url = new URL ("http://222.91.187.11:8080/teacherInformationController/plShowWOrkInformation.action?twid=" + twid);
            System.out.println ("http://222.91.187.11:8080/teacherInformationController/plShowWOrkInformation.action?twid=" + Dow.this.twid);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
            StringBuilder sb = new StringBuilder ();
            List list = new ArrayList<> ();
            if (httpURLConnection.getResponseCode () == 200) {
                InputStream is = httpURLConnection.getInputStream ();
                //面对获取的输入流进行读取
                BufferedReader br = new BufferedReader (new InputStreamReader (is));
                String line;
                while ((line = br.readLine ()) != null) {
                    sb.append (line);
                }
            }
            List<PlDownload> plDownloads = new ArrayList<PlDownload> ();
            String str = sb.toString ();
            System.out.println (str);
            str = str.substring (1, str.length () - 1);
            str = str.substring (1, str.length () - 1);
            String[] split = str.split ("\\},\\{");
            for (String s : split) {
                if (s.indexOf ("null") == -1) {
                    String[] sp = s.split (",");
                    String filename = sp[0].split ("\":\"")[1].substring (0, sp[0].split ("\":\"")[1].length () - 1);
                    String path = sp[1].split ("\":\"")[1].substring (0, sp[1].split ("\":\"")[1].length () - 1);
                    String classname = sp[2].split ("\":\"")[1].substring (0, sp[2].split ("\":\"")[1].length () - 1);
                    PlDownload pl = new PlDownload ();
                    pl.setClassname (classname);
                    pl.setFilename (filename);
                    pl.setPath (path);
                    plDownloads.add (pl);
                }
            }
            dowload (plDownloads, Filepath);
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

    private void dowload(List<PlDownload> plDownloads, String path) {
        for (PlDownload p : plDownloads) {
            try {
                URL url = new URL ("http://222.91.187.11:8080/work/" + p.getPath ());
                System.out.println ("http://222.91.187.11:8080/work/" + p.getPath ());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection ();
                InputStream inputStream = httpURLConnection.getInputStream ();
                File file = new File (path + p.getClassname ().trim ());
                if (!file.exists ()) {
                    file.mkdir ();
                }
                File newFile = new File (path + p.getClassname ().trim () + "/" + p.getFilename ().trim ());
                System.out.println (path + p.getClassname ().trim () + "/" + p.getFilename ().trim ());
                newFile.createNewFile ();
                FileOutputStream fileOutputStream = new FileOutputStream (newFile);
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = inputStream.read (bytes)) > 0) {
                    fileOutputStream.write (bytes, 0, len);
                }
                fileOutputStream.close ();
                inputStream.close ();
                System.out.println (inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace ();
            } catch (FileNotFoundException e) {
                e.printStackTrace ();
            } catch (IOException e) {
                e.printStackTrace ();
            }


        }
    }

}
