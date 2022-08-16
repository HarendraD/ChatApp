package Client_Side.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.ArrayList;

public class ClientLoginFormController {
    public static String userName;
    public static ArrayList<String> users = new ArrayList<>();
    public TextField txtName;
    public AnchorPane loginPane;

    public void loginBtnOnAction(ActionEvent actionEvent) throws IOException {
        userName = txtName.getText().trim();
        boolean flag = false;
        if (users.isEmpty()) {
            users.add(userName);
            flag = true;
        }

        for (String s : users) {
            if (!s.equalsIgnoreCase(userName)) {
                flag = true;
                System.out.println(userName);
                break;
            }
        }

        if (flag) {
            loginPane.getChildren().clear();
            AnchorPane pane=FXMLLoader.load(getClass().getResource("../view/ChatForm.fxml"));
            loginPane.getChildren().setAll(pane);
        }
    }
}
