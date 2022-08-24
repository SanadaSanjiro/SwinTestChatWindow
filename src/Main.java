import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

class Main {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Создаем менеджер расположения (последовательное расположение с выравниванием по левому краю
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);

        //Создаем вернюю панель с элементами меню
        JPanel northPanel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        JMenu menuObj1 = new JMenu("FILE");
        JMenu menuObj2 = new JMenu("Help");
        menuBar.add(menuObj1);
        menuBar.add(menuObj2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        menuObj1.add(m11);
        menuObj1.add(m22);
        northPanel.add(menuBar);
        northPanel.setLayout(flowLayout);

        //Создаем текстовое поле
        JTextArea textArea = new JTextArea();
        textArea.setText("Начало беседы");

        //Создаем нижнюю панель с полем ввода текста и кнопками
        JPanel southPanel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField textField = new JTextField(10); // accepts upto 10 characters

        //добавляем обработчик событий для отправки сообщений по нажатию ENTER
        textField.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField.getText();
                textField.setText("");
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                message = System.lineSeparator() + df.format(date) + " > " +  message;
                textArea.append(message);
            }
        });

        JButton sendButton = new JButton();
        sendButton.setText("Send"); //текст кнопки
        sendButton.setName("Send"); //наименование кнопки
        sendButton.setMnemonic('S'); //привязываем к кнопке клавишу быстрого набора
        sendButton.setDisplayedMnemonicIndex(0); //указываем какой симво подчеркивать как клавишу быстрого набора
        sendButton.addActionListener(new Action() { //создаем слушатель событий, привязываем его к кнопке
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            //создаем обработку события по нажатию кнопки
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField.getText();
                textField.setText("");
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                message = System.lineSeparator() + df.format(date) + " > " +  message;
                textArea.append(message);
            }
        });

        JButton resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setName("Reset");
        resetButton.addActionListener(new Action() { //создаем слушатель событий, привязываем его к кнопке
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });


        southPanel.add(label); // Components Added using Flow Layout
        southPanel.add(textField);
        southPanel.add(sendButton);
        southPanel.add(resetButton);
        southPanel.setLayout(flowLayout);


        frame.getContentPane().add(BorderLayout.NORTH, northPanel); //помещаем на верх верхнюю панель
        frame.getContentPane().add(BorderLayout.SOUTH, southPanel); //помещаем вниз нижнюю панель
        frame.getContentPane().add(BorderLayout.CENTER, textArea); //размещаем в центре текстовое поле
        frame.setVisible(true);

    }
}