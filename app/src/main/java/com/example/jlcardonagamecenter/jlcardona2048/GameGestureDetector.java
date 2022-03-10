package com.example.jlcardonagamecenter.jlcardona2048;

public interface GameGestureDetector {
    public void addSwipeGestureListener(SwipeGestureListener listener);
    public void removeSwipeGestureListener(SwipeGestureListener listener);
    public void clearSwipeGestureListeners();
}
