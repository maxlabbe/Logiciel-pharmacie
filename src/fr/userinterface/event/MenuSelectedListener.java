package fr.userinterface.event;

import java.util.EventListener;

public interface MenuSelectedListener extends EventListener {
    public void OnMenuSelected(MenuSelectedEvent e);
}
