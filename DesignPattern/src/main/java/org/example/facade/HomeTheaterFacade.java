package org.example.facade;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/10/3 12:05
 */
public class HomeTheaterFacade {

    // 定义各个子系统对象
    private TheaterLight theaterLight;

    private Popcorn popcorn;

    private Stereo stereo;

    private Projector projector;

    private Screen screen;

    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade() {
        this.theaterLight = TheaterLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    public void ready() {
        this.popcorn.on();
        this.popcorn.pop();
        this.screen.down();
        this.projector.on();
        this.stereo.on();
        this.dvdPlayer.on();
        this.theaterLight.dim();
    }

    public void play() {
        this.dvdPlayer.play();
    }

    public void pause() {
        this.dvdPlayer.pause();
    }

    public void end() {
        this.popcorn.off();
        this.theaterLight.bright();
        this.screen.up();
        this.projector.off();
        this.stereo.off();
        this.dvdPlayer.off();
    }
}
