package com.ca2le.production.VHSClub;

public class VideoCasetteNotFoundException  extends RuntimeException {

    VideoCasetteNotFoundException(Long id) {
            super("Sorry! Your videocassette with ID: " + id + " was impossible to find!");

    }

}
