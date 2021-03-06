package GraphicalUserInterface;

import GraphicalUserInterface.GPanes.VisualSpace.VisualSpaceControlCenter;

import javax.swing.*;
import java.awt.*;

public interface GInterface {
    public void setSpaceForInteraction(JPanel spaceForInteraction);

    public void setGPane(WindowPane windowPane);

    public void removeWindow();

    public void restartWindow();

    public void creatingWindow();

    public void setTopPartOfWindow(WindowPane topPartOfWindow);

    public void repaint();

    public Dimension getMainWindowSize();

    public void sendNotification(String string, String title);

    public void clearSpaceForInteraction();

    public void setSizeForLanguagePale(Dimension dimension);

    public void setMinimalSizeForMainWindow(Dimension dimension);

    public void setMinimumSpaceForInteractionSize(Dimension dimension);

    public MainWindow getMainWindow();

    public void setVisualSpaceControlCenter(VisualSpaceControlCenter visualSpaceControlCenter);
}
