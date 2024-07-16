import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class Converter extends JFrame implements ActionListener {
    Choice choiceFrom,choiceTo;
    JButton enter;
    JTextField amount;
    JLabel converted;
    public Converter(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome to currency converter");
        heading.setBounds(50,10,300,50);
        heading.setFont(new Font("Roboto",Font.BOLD,20));
        add(heading);

        JLabel from = new JLabel("Currency converting from ?");
        from.setBounds(20,80,200,30);
        add(from);

        choiceFrom = new Choice();
        choiceFrom.addItem("USD");
        choiceFrom.addItem("PKR");
        choiceFrom.addItem("INR");
        choiceFrom.addItem("CAD");
        choiceFrom.addItem("HKD");

        JLabel to = new JLabel("Currency converting to ?");
        to.setBounds(20,120,200,30);
        add(to);

        choiceTo = new Choice();
        choiceTo.addItem("---");
        choiceTo.addItem("USD");
        choiceTo.addItem("PKR");
        choiceTo.addItem("INR");
        choiceTo.addItem("CAD");
        choiceTo.addItem("HKD");


        choiceTo.setBounds(250,120,100,30);
        choiceFrom.setBounds(250,80,100,30);
        add(choiceTo);
        add(choiceFrom);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setBounds(20,160,200,30);
        add(lblAmount);

        amount = new JTextField();
        amount.setBounds(250,160,100,30);
        add(amount);

        JLabel lblConverted = new JLabel("Converted");
        lblConverted.setBounds(20,200,200,30);
        add(lblConverted);

        converted = new JLabel();
        converted.setBounds(250,200,100,30);
        converted.setFont(new Font("Roboto",Font.PLAIN,13));
        add(converted);

        enter = new JButton("Enter");
        enter.setBounds(150,300,100,30);
        enter.addActionListener(this);
        add(enter);

        setVisible(true);
        setTitle("Currency Converter");
        setBounds(200,40,500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Converter();
    }
    private void apiFetch(String from, String to, String amount){
        String api = "https://v6.exchangerate-api.com/v6/d0abe939463efc178f7a531f/latest/"+from;
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject object = new JSONObject(response.body());
            JSONObject conversion = object.getJSONObject("conversion_rates");
            converted.setText(String.valueOf(conversion.getDouble(to) * Double.parseDouble(amount)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter){
            apiFetch(choiceFrom.getSelectedItem(),choiceTo.getSelectedItem(),amount.getText());
        }
    }
}
