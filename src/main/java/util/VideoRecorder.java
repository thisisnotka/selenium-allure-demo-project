package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import io.qameta.allure.Allure;

public class VideoRecorder {
    private Process ffmpegProcess;
    private String videoFilePath;

    public VideoRecorder(String testName, File movieFolder) {
        videoFilePath = new File(movieFolder, testName + ".mp4").getAbsolutePath();
    }

    public void start() throws IOException {
        String displayEnv = System.getenv("DISPLAY");

        if (displayEnv == null || displayEnv.isEmpty()) {
            throw new IllegalStateException("DISPLAY environment variable is not set. Please make sure Xvfb is running.");
        }

        ProcessBuilder pb = new ProcessBuilder(
                "ffmpeg",
                "-y", // overwrite existing file
                "-f", "x11grab", // X11 screen capture
                "-s", "1920x1080", // screen resolution
                "-i", displayEnv, // the DISPLAY environment variable
                "-r", "25", // frame rate
                videoFilePath
        );
        pb.redirectErrorStream(true);
        ffmpegProcess = pb.start();
    }

    public void stop() {
        if (ffmpegProcess != null) {
            ffmpegProcess.destroy();
        }
    }

    public String getVideoFilePath() {
        return videoFilePath;
    }

    public void attachVideoToAllure() {
        File videoFile = new File(videoFilePath);
        if (videoFile.exists()) {
            try (InputStream is = new FileInputStream(videoFile)) {
                Allure.addAttachment("Test Video", "video/mp4", is, "mp4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Video file does not exist: " + videoFilePath);
        }
    }
}
