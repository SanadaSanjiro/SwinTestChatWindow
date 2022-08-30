import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ChatFrame extends JFrame {
    JPanel northPanel;
    JMenuBar menuBar;
    JMenu menuObj1;
    JMenu menuObj2;
    JMenuItem menuOpen;
    JMenuItem menuSave;
    JMenuItem menuExit;
    JTextArea textArea;
    JScrollPane scrollPane;
    JPanel southPanel;
    JLabel label;
    JTextField textField;
    JButton sendButton;
    JButton resetButton;

    public ChatFrame() {
        super("Чат");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        //Создаем менеджер расположения (последовательное расположение с выравниванием по левому краю
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);

        //Создаем вернюю панель с элементами меню
        northPanel = new JPanel();
        menuBar = new JMenuBar();
        menuObj1 = new JMenu("FILE");
        menuObj2 = new JMenu("Help");
        menuBar.add(menuObj1);
        menuBar.add(menuObj2);
        menuOpen = new JMenuItem("Open");
        menuSave = new JMenuItem("Save as");
        menuExit = new JMenuItem("Exit");
        menuObj1.add(menuOpen);
        menuObj1.add(menuSave);
        menuObj1.add(menuExit);
        northPanel.add(menuBar);
        northPanel.setLayout(flowLayout);

        menuExit.setAccelerator(KeyStroke.getKeyStroke('x'));
        menuExit.setMnemonic('x');
        menuExit.addActionListener(new Action() {
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
                System.exit(0);
            }
        });

        //Создаем текстовое поле и панель с прокруткой
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Начало беседы");
        scrollPane = new JScrollPane(textArea);

        //Создаем нижнюю панель с полем ввода текста и кнопками
        southPanel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Enter Text");
        textField = new JTextField(10); // accepts upto 10 characters

        //добавляем обработчик событий для отправки сообщений
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
                sendText();
            }
        });

        sendButton = new JButton();
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
                sendText();
            }
        });

        resetButton = new JButton();
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


        getContentPane().add(BorderLayout.NORTH, northPanel); //помещаем на верх верхнюю панель
        getContentPane().add(BorderLayout.SOUTH, southPanel); //помещаем вниз нижнюю панель
        getContentPane().add(BorderLayout.CENTER, scrollPane); //размещаем в центре текстовое поле
        setVisible(true);
    }

    private void sendText () {
        String message = textField.getText();
        String text = textArea.getText();
        textField.setText("");
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        text += System.lineSeparator() + df.format(date) + " > " + message;
        textArea.setText(text);
    }
}
