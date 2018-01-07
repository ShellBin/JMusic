package main;

import java.io.File;  
import java.io.IOException;  	//Java 对文件的操作
  
import javax.sound.sampled.AudioFormat;  
import javax.sound.sampled.AudioInputStream;  
import javax.sound.sampled.AudioSystem;  
import javax.sound.sampled.DataLine;  
import javax.sound.sampled.SourceDataLine;	//Java sound API调用

   
public class Player {  
   
    public void play(String filePath) {  
        final File file = new File(filePath);  
   
        try {  
            final AudioInputStream in = AudioSystem.getAudioInputStream(file);  
               
            final AudioFormat outFormat = getOutFormat(in.getFormat());  
            final DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);  
   
            final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);  
   
            if (line != null) {  
                line.open(outFormat);  
                line.start();  
                stream(AudioSystem.getAudioInputStream(outFormat, in), line);  
                line.drain();  
                line.stop();  
            }  
   
        } catch (Exception e) {  
            throw new IllegalStateException(e);  
        }  
    }  
   
    private AudioFormat getOutFormat(AudioFormat inFormat) {  
        final int ch = inFormat.getChannels();  
        final float rate = inFormat.getSampleRate();  
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);  
    }  
   
    private void stream(AudioInputStream in, SourceDataLine line)  
        throws IOException {  
        final byte[] buffer = new byte[65536];  
        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {  
            line.write(buffer, 0, n);  
        }  
    } 

    public static void main(String[] args) {  
        final Player player = new Player ();  
        System.out.println("开始播放");
        player.play("D:/test.mp3");  
        System.out.println("播放结束");
    }  
    
}  