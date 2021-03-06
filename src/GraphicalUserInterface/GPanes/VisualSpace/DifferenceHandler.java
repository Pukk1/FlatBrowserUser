package GraphicalUserInterface.GPanes.VisualSpace;

import CommonClasses.CommandsData;
import CommonClasses.Flat;
import GraphicalUserInterface.GInterface;
import HelpingModuls.ConnectionException;
import User.ProcessControlCenter;
import User.TransferCenter;
import User.UserWork;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class DifferenceHandler implements Runnable{

    private Flat[] flatsFromDB;
    private Flat[] flatsHear;
    private GVisualSpace gVisualSpace;
    private UserWork userWork;
    private TransferCenter transferCenter;
    private ProcessControlCenter processControlCenter;
    private String[][] userColourVariations;
    private Boolean stop = false;
    private GInterface gInterface;
    private ResourceBundle resourceBundle;

    public DifferenceHandler(Flat[] flats, GVisualSpace gVisualSpace, ProcessControlCenter processControlCenter, UserWork userWork, TransferCenter transferCenter, String[][] userColourVariations, GInterface gInterface, ResourceBundle resourceBundle){
        this.gInterface = gInterface;
        this.flatsHear = flats;
        this.gVisualSpace = gVisualSpace;
        this.userWork = userWork;
        this.transferCenter = transferCenter;
        this.userColourVariations = userColourVariations;
        this.processControlCenter = processControlCenter;
        this.resourceBundle = resourceBundle;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {

        UserWork.CommunicateWithServerByCommands communicateWithServerByCommands = userWork.new CommunicateWithServerByCommands();

        while (!stop){
            try {
                flatsFromDB = communicateWithServerByCommands.processCommand(CommandsData.SHOW, transferCenter).getFlats();
            } catch (ConnectionException e) {
                JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Сервер не отвечает!"), resourceBundle.getString("Ошибка подключения"), JOptionPane.OK_CANCEL_OPTION);
                processControlCenter.reConnect();
//                processControlCenter.working();
                return;
            }

            if(flatsFromDB.length == flatsHear.length){
                boolean changes = false;
                for(int i =0; i < flatsFromDB.length; i++){
                    if(!(flatsFromDB[i].getId().equals(flatsHear[i].getId()))){
                        changes = true;
                    }
                }
                if(changes == true){
                    flatsHear = flatsFromDB;
                    userColourVariations = createUserColourVariations(flatsHear);
                    gInterface.repaint();
                    setStop(true);
                }
            }
            else {
                flatsHear = flatsFromDB;
                userColourVariations = createUserColourVariations(flatsHear);
                gInterface.repaint();
                setStop(true);
            }
        }
    }

    public static String[][] createUserColourVariations(Flat[] flatsHear){
        int numberOfAnother = 0;
        ArrayList<String> arrayList = new ArrayList();
        for(int i =0; i< flatsHear.length; i++){
            boolean repeat = false;
            for(int j = 0; j< i;j++){
                if(flatsHear[i].getUserName().equals(flatsHear[j].getUserName())){
                    repeat = true;
                }
            }
            if(repeat == false){
                numberOfAnother++;
                arrayList.add(flatsHear[i].getUserName());
            }
        }
        Object[] users = arrayList.toArray();
        String[][] userColourVariations;
        userColourVariations = new String[numberOfAnother][2];

        for(int i =0; i< numberOfAnother; i++){
            userColourVariations[i][0] = (String) users[i];
            userColourVariations[i][1] = String.valueOf(new Random().nextInt());
        }

        return userColourVariations;
    }
}
