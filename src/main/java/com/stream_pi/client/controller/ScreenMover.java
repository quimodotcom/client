package com.stream_pi.client.controller;

import com.stream_pi.client.window.Base;
import com.stream_pi.util.exception.SevereException;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class ScreenMover
{
    private Timer timer;

    private long interval;

    private boolean isOldLocation;
    private double originalX, originalY;
    private double changeX, changeY;

    private Stage stage;

    public ScreenMover(Stage stage, long interval, int changeX, int changeY)
    {
        this.stage = stage;
        this.changeX = changeX;
        this.changeY = changeY;
        this.originalX = stage.getX();
        this.originalY = stage.getY();
        this.isOldLocation = true;
        this.interval = interval;

        startTimer();
    }


    public void stop()
    {
        isOldLocation = true;
        shiftScreen();

        stopTimer();
    }

    public void restart()
    {
        stop();
        startTimer();
    }

    private void shiftScreen()
    {
        Platform.runLater(()->{
            if(isOldLocation)
            {
                isOldLocation = false;

                stage.setX(originalX+changeX);
                stage.setY(originalY+changeY);
            }
            else
            {
                isOldLocation = true;

                stage.setX(originalX);
                stage.setY(originalY);
            }
        });
    }

    public void setInterval(int seconds)
    {
        this.interval = seconds;
    }

    private void stopTimer()
    {
        if(timer != null)
        {
            timer.cancel();
            timer.purge();
        }
    }

    private void startTimer()
    {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                shiftScreen();
            }
        },interval, interval);
    }
}
