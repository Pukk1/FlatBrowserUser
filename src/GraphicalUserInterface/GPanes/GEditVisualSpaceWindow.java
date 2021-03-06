package GraphicalUserInterface.GPanes;

import CommonClasses.ApartmentDescription.*;
import CommonClasses.CommandsData;
import CommonClasses.DataBlock;
import CommonClasses.Flat;
import GraphicalUserInterface.GInterface;
import GraphicalUserInterface.WindowPane;
import HelpingModuls.ConnectionException;
import User.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ResourceBundle;

public class GEditVisualSpaceWindow implements WindowPane {

    private TransferCenter transferCenter;
    private GInterface gInterface;
    private UserWork userWork;
    private ProcessControlCenter processControlCenter;
    private Flat flatFirst;
    private ResourceBundle resourceBundle;
    private JPanel flatInfoPale;

    public GEditVisualSpaceWindow(Flat flatFirst, TransferCenter transferCenter, GInterface gInterface, UserWork userWork, ProcessControlCenter processControlCenter, JPanel flatInfoPale, ResourceBundle resourceBundle){
        this.transferCenter = transferCenter;
        this.gInterface = gInterface;
        this.userWork = userWork;
        this.processControlCenter = processControlCenter;
        this.flatFirst = flatFirst;
        this.flatInfoPale = flatInfoPale;
        this.resourceBundle = resourceBundle;
    }

    @Override
    public void setLocale(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public JPanel getPanel(){
        return createEditPanel();
    }

    private JPanel createEditPanel(){
        JPanel mainPanel = new JPanel();

//        JButton back = new JButton(resourceBundle.getString("НАЗАД"));
//        back.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                mainPanel.setVisible(false);
//                flatInfoPale.setVisible(true);
//            }
//        });
//        mainPanel.add(back);
//
//        JLabel nameLabel = new JLabel("Имя");
//        JTextField nameTextField = new JTextField(flatFirst.getName());
//        JLabel coordinateXLabel = new JLabel("Координата x");
//        JTextField coordinateXTextField = new JTextField(String.valueOf(flatFirst.getCoordinates().getX()));
//        JLabel coordinateYLabel = new JLabel("Координата y");
//        JTextField coordinateYTextField = new JTextField(String.valueOf(flatFirst.getCoordinates().getY()));
//        JLabel areaLabel = new JLabel("Расположение");
//        JTextField areaTextField = new JTextField(String.valueOf(flatFirst.getArea()));
//        JLabel numberOfRoomsLabel = new JLabel("Количество комнат");
//        JTextField numberOfRoomsTextField = new JTextField(String.valueOf(flatFirst.getNumberOfRooms()));
//        JLabel furnishLabel = new JLabel("Мебель");
//        JTextField furnishTextField = new JTextField(String.valueOf(flatFirst.getFurnish()));
//        JLabel viewLabel = new JLabel("Вид");
//        JTextField viewTextField;
//        if(flatFirst.getView() != null){
//            viewTextField = new JTextField(flatFirst.getView().name());
//        }
//        else {
//            viewTextField = new JTextField("");
//        }
//        JLabel transportLabel = new JLabel("Транспортные маршруты");
//        JTextField transportTextField;
//        if(flatFirst.getView() != null){
//            transportTextField = new JTextField(flatFirst.getTransport().name());
//        }
//        else {
//            transportTextField = new JTextField("");
//        }
//
//        JLabel houseNameLabel;
//        JTextField houseNameTextField;
//        JLabel houseYearLabel;
//        JTextField houseYearTextField;
//        JLabel houseNumberOfFloorsLabel;
//        JTextField houseNumberOfFloorsTextField;
//        JLabel houseNumberOfFlatsOnFloorLabel;
//        JTextField houseNumberOfFlatsOnFloorTextField;
//        JLabel houseNumberOfLiftsLabel;
//        JTextField houseNumberOfLiftsTextField;
//        if(flatFirst.getHouse() != null){
//            houseNameLabel = new JLabel("Имя дома");
//            houseNameTextField = new JTextField(flatFirst.getHouse().getName());
//            houseYearLabel = new JLabel("Год пострйки дома");
//            houseYearTextField = new JTextField(String.valueOf(flatFirst.getHouse().getYear()));
//            houseNumberOfFloorsLabel = new JLabel("Количество этажей в доме");
//            houseNumberOfFloorsTextField = new JTextField(String.valueOf(flatFirst.getHouse().getNumberOfFloors()));
//            houseNumberOfFlatsOnFloorLabel = new JLabel("Количество квартир на одном этаже");
//            houseNumberOfFlatsOnFloorTextField = new JTextField(flatFirst.getHouse().getNumberOfFlatsOnFloor());
//            houseNumberOfLiftsLabel = new JLabel("Количество лифтов");
//            houseNumberOfLiftsTextField = new JTextField(String.valueOf(flatFirst.getHouse().getNumberOfLifts()));
//        }
//        else {
//            houseNameLabel = new JLabel("Имя дома");
//            houseNameTextField = new JTextField("");
//            houseYearLabel = new JLabel("Год пострйки дома");
//            houseYearTextField = new JTextField("");
//            houseNumberOfFloorsLabel = new JLabel("Количество этажей в доме");
//            houseNumberOfFloorsTextField = new JTextField("");
//            houseNumberOfFlatsOnFloorLabel = new JLabel("Количество квартир на одном этаже");
//            houseNumberOfFlatsOnFloorTextField = new JTextField("");
//            houseNumberOfLiftsLabel = new JLabel("Количество лифтов");
//            houseNumberOfLiftsTextField = new JTextField("");
//        }
//
//        JButton saveEdit = new JButton("Сохранить изменения");
//
//
//
//
//        mainPanel.add(saveEdit);
//        mainPanel.add(nameLabel);
//        mainPanel.add(nameTextField);
//        mainPanel.add(coordinateXLabel);
//        mainPanel.add(coordinateXTextField);
//        mainPanel.add(coordinateYLabel);
//        mainPanel.add(coordinateYTextField);
//        mainPanel.add(areaLabel);
//        mainPanel.add(areaTextField);
//        mainPanel.add(numberOfRoomsLabel);
//        mainPanel.add(numberOfRoomsTextField);
//        mainPanel.add(furnishLabel);
//        mainPanel.add(furnishTextField);
//        mainPanel.add(viewLabel);
//        mainPanel.add(viewTextField);
//        mainPanel.add(transportLabel);
//        mainPanel.add(transportTextField);
//        mainPanel.add(houseNameLabel);
//        mainPanel.add(houseNameTextField);
//        mainPanel.add(houseYearLabel);
//        mainPanel.add(houseYearTextField);
//        mainPanel.add(houseNumberOfFloorsLabel);
//        mainPanel.add(houseNumberOfFloorsTextField);
//        mainPanel.add(houseNumberOfFlatsOnFloorLabel);
//        mainPanel.add(houseNumberOfFlatsOnFloorTextField);
//        mainPanel.add(houseNumberOfLiftsLabel);
//        mainPanel.add(houseNumberOfLiftsTextField);







        JButton back = new JButton("Назад");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flatInfoPale.setVisible(true);
                mainPanel.setVisible(false);
            }
        });

        back.setFont(new Font("Dialog", Font.PLAIN, 20));
        back.setBackground(new Color(0xFFD9ECEF, true));
        mainPanel.add(back);


        JPanel abstractFields = new JPanel();
        abstractFields.add(back);
        abstractFields.setLayout(new GridLayout(14, 2));
        abstractFields.setPreferredSize(new Dimension(500, 560));


        JLabel nameLabel = new JLabel(resourceBundle.getString("Имя"));
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField nameTextField = new JTextField(flatFirst.getName());
        nameTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel coordinateXLabel = new JLabel(resourceBundle.getString("Координата x"));
        coordinateXLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField coordinateXTextField = new JTextField(flatFirst.getCoordinates().getX() + "");
        coordinateXTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel coordinateYLabel = new JLabel(resourceBundle.getString("Координата y"));
        coordinateYLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField coordinateYTextField = new JTextField(flatFirst.getCoordinates().getY() + "");
        coordinateYTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel areaLabel = new JLabel(resourceBundle.getString("Расположение"));
        areaLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField areaTextField = new JTextField(flatFirst.getArea() + "");
        areaTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel numberOfRoomsLabel = new JLabel(resourceBundle.getString("Количество комнат"));
        numberOfRoomsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField numberOfRoomsTextField = new JTextField(flatFirst.getNumberOfRooms() + "");
        numberOfRoomsTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel furnishLabel = new JLabel(resourceBundle.getString("Мебель"));
        furnishLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField furnishTextField = new JTextField(flatFirst.getFurnish().name());
        furnishTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel viewLabel = new JLabel(resourceBundle.getString("Вид"));
        viewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField viewTextField;
        if(flatFirst.getView() != null){
             viewTextField = new JTextField(flatFirst.getView().name());
        }
        else {
            viewTextField = new JTextField("");
        }
        viewTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel transportLabel = new JLabel(resourceBundle.getString("Транспортные маршруты"));
        transportLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        JTextField transportTextField;
        if(flatFirst.getView() != null){
            transportTextField = new JTextField(flatFirst.getTransport().name());
        }
        else {
            transportTextField = new JTextField("");
        }
        transportTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

        JLabel houseNameLabel;
        JTextField houseNameTextField;
        JLabel houseYearLabel;
        JTextField houseYearTextField;
        JLabel houseNumberOfFloorsLabel;
        JTextField houseNumberOfFloorsTextField;
        JLabel houseNumberOfFlatsOnFloorLabel;
        JTextField houseNumberOfFlatsOnFloorTextField;
        JLabel houseNumberOfLiftsLabel;
        JTextField houseNumberOfLiftsTextField;

        if(flatFirst.getHouse() != null) {
            houseNameLabel = new JLabel(resourceBundle.getString("Имя дома"));
            houseNameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

            houseNameTextField = new JTextField(flatFirst.getHouse().getName());
            houseNameTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseYearLabel = new JLabel(resourceBundle.getString("Год пострйки дома"));
            houseYearLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseYearTextField = new JTextField(flatFirst.getHouse().getYear() + "");
            houseYearTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFloorsLabel = new JLabel(resourceBundle.getString("Количество этажей в доме"));
            houseNumberOfFloorsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFloorsTextField = new JTextField(flatFirst.getHouse().getNumberOfFloors() + "");
            houseNumberOfFloorsTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFlatsOnFloorLabel = new JLabel(resourceBundle.getString("Количество квартир на одном этаже"));
            houseNumberOfFlatsOnFloorLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFlatsOnFloorTextField = new JTextField(flatFirst.getHouse().getNumberOfFlatsOnFloor() + "");
            houseNumberOfFlatsOnFloorTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfLiftsLabel = new JLabel(resourceBundle.getString("Количество лифтов"));
            houseNumberOfLiftsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfLiftsTextField = new JTextField(flatFirst.getHouse().getNumberOfLifts() + "");
            houseNumberOfLiftsTextField.setFont(new Font("Dialog", Font.PLAIN, 15));
        }
        else {
             houseNameLabel = new JLabel(resourceBundle.getString("Имя дома"));
            houseNameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

            houseNameTextField = new JTextField("");
            houseNameTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseYearLabel = new JLabel(resourceBundle.getString("Год пострйки дома"));
            houseYearLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseYearTextField = new JTextField("");
            houseYearTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFloorsLabel = new JLabel(resourceBundle.getString("Количество этажей в доме"));
            houseNumberOfFloorsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFloorsTextField = new JTextField("");
            houseNumberOfFloorsTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFlatsOnFloorLabel = new JLabel(resourceBundle.getString("Количество квартир на одном этаже"));
            houseNumberOfFlatsOnFloorLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfFlatsOnFloorTextField = new JTextField("");
            houseNumberOfFlatsOnFloorTextField.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfLiftsLabel = new JLabel(resourceBundle.getString("Количество лифтов"));
            houseNumberOfLiftsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

             houseNumberOfLiftsTextField = new JTextField("");
            houseNumberOfLiftsTextField.setFont(new Font("Dialog", Font.PLAIN, 15));
        }



        JButton saveEdit = new JButton(resourceBundle.getString("Сохранить изменения"));
        saveEdit.setFont(new Font("Dialog", Font.PLAIN, 20));
        saveEdit.setBackground(new Color(0xFFD9ECEF, true));


        abstractFields.add(saveEdit);
        abstractFields.add(nameLabel);
        abstractFields.add(nameTextField);
        abstractFields.add(coordinateXLabel);
        abstractFields.add(coordinateXTextField);
        abstractFields.add(coordinateYLabel);
        abstractFields.add(coordinateYTextField);
        abstractFields.add(areaLabel);
        abstractFields.add(areaTextField);
        abstractFields.add(numberOfRoomsLabel);
        abstractFields.add(numberOfRoomsTextField);
        abstractFields.add(furnishLabel);
        abstractFields.add(furnishTextField);
        abstractFields.add(viewLabel);
        abstractFields.add(viewTextField);
        abstractFields.add(transportLabel);
        abstractFields.add(transportTextField);
        abstractFields.add(houseNameLabel);
        abstractFields.add(houseNameTextField);
        abstractFields.add(houseYearLabel);
        abstractFields.add(houseYearTextField);
        abstractFields.add(houseNumberOfFloorsLabel);
        abstractFields.add(houseNumberOfFloorsTextField);
        abstractFields.add(houseNumberOfFlatsOnFloorLabel);
        abstractFields.add(houseNumberOfFlatsOnFloorTextField);
        abstractFields.add(houseNumberOfLiftsLabel);
        abstractFields.add(houseNumberOfLiftsTextField);

        mainPanel.add(abstractFields);





        saveEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if(nameTextField.getText().equals("")){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("У квартиры обязательно должно быть имя"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if(coordinateXTextField.getText().equals("")){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("У квартиры обязательно должна быть координата по X"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if(coordinateYTextField.getText().equals("")){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("У квартиры обязательно должно быть координата по Y"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if(areaTextField.getText().equals("")){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("У квартиры обязательно должно быть расположение"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if(numberOfRoomsTextField.getText().equals("")){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("У квартиры обязательно должно быть количество комнат"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if(furnishTextField.getText().equals("")){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("У квартиры обязательно должна быть мебель"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if((!houseNameTextField.getText().equals("") | !houseYearTextField.getText().equals("") |
                        !houseNumberOfFloorsTextField.getText().equals("") | !houseNumberOfFlatsOnFloorTextField.getText().equals("") | !houseNumberOfLiftsTextField.getText().equals("")) &
                        (houseNameTextField.getText().equals("") | houseYearTextField.getText().equals("") | houseNumberOfFloorsTextField.getText().equals("") |
                                houseNumberOfFlatsOnFloorTextField.getText().equals("") | houseNumberOfLiftsTextField.getText().equals(""))){

                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Все поля связанные с домом либо пустые, либо заполненные"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                    return;
                }
                if(!furnishTextField.getText().equals("")) {
                    try {
                        Furnish.valueOf(furnishTextField.getText());
                    } catch (IllegalArgumentException illegalArgumentException) {
                        JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Мебель задана некорректно!"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                        return;
                    }
                }
                if(!transportTextField.getText().equals("")) {
                    try {
                        Transport.valueOf(transportTextField.getText());
                    } catch (IllegalArgumentException illegalArgumentException) {
                        JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Транспорт задан некорректно!"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                        return;
                    }
                }
                if(!viewTextField.getText().equals("")) {
                    try {
                        View.valueOf(viewTextField.getText());
                    } catch (IllegalArgumentException illegalArgumentException) {
                        JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Вид задан некорректно!"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                        return;
                    }
                }
                CommandsData commandsData = CommandsData.REMOVEBYID;
                commandsData.setParameter(String.valueOf(flatFirst.getId()));
                DataBlock dataBlock;

                try {
                    dataBlock = userWork.new CommunicateWithServerByCommands().processCommand(commandsData, transferCenter);
                }catch (ConnectionException connectionException){
                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Потеряно соединение с сервером!"), resourceBundle.getString("Ошибка подключения"), JOptionPane.OK_CANCEL_OPTION);
                    processControlCenter.reConnect();
                    processControlCenter.working();
                    return;
                }

                if(dataBlock.getPhrase().equals(resourceBundle.getString("Удаление прошло успешно."))){
//                    System.out.println("Удаление прошло успешно.");
                    commandsData = CommandsData.ADD;


                    Flat flat = new Flat();
                    flat.setUserName(userWork.getMainUser().getLogin());
                    flat.setId(Long.valueOf(flatFirst.getId()));
                    flat.setName(nameTextField.getText());
                    Coordinates coordinates = new Coordinates();
                    coordinates.setX(Double.valueOf(coordinateXTextField.getText()));
                    coordinates.setY(Integer.valueOf(coordinateYTextField.getText()));
                    flat.setCoordinates(coordinates);
                    flat.setCreationDate(new Date());
                    flat.setArea(Long.valueOf(areaTextField.getText()));
                    flat.setNumberOfRooms(Long.valueOf(numberOfRoomsTextField.getText()));
                    flat.setFurnish(Furnish.valueOf(furnishTextField.getText()));
                    if(viewTextField.getText().equals("")){
                        flat.setView(null);
                    }
                    else {
                        flat.setView(View.valueOf(viewTextField.getText()));
                    }
                    if(transportTextField.getText().equals("")){
                        flat.setTransport(null);
                    }
                    else {
                        flat.setTransport(Transport.valueOf(transportTextField.getText()));
                    }
                    House house = new House();
                    if(!houseNameTextField.getText().equals("")){
                        house.setName(houseNameTextField.getText());
                        house.setYear(Long.valueOf(houseYearTextField.getText()));
                        house.setNumberOfFloors(Long.valueOf(houseNumberOfFloorsTextField.getText()));
                        house.setNumberOfFlatsOnFloor(Integer.valueOf(houseNumberOfFlatsOnFloorTextField.getText()));
                        house.setNumberOfLifts(Long.valueOf(houseNumberOfLiftsTextField.getText()));
                    }
                    flat.setHouse(house);
//                    System.out.println("ttt");
//                    System.out.println(flat.show());
                    commandsData.setFlat(flat);


                    try {
                        userWork.new CommunicateWithServerByCommands().processCommand(commandsData, transferCenter);
                    }catch (ConnectionException connectionException){
                        JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Потеряно соединение с сервером!"), resourceBundle.getString("Ошибка подключения"), JOptionPane.OK_CANCEL_OPTION);
                        processControlCenter.reConnect();
                        processControlCenter.working();
                        return;
                    }

                    JOptionPane.showConfirmDialog(new JOptionPane(), resourceBundle.getString("Объект успешно обновлён"), resourceBundle.getString("Уведомление"), JOptionPane.OK_CANCEL_OPTION);
                }

            }
        });


        return mainPanel;
    }
}