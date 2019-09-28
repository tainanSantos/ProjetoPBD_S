package projeto_pbd.com.br.msg;

import javafx.scene.control.Alert;

public class Mensagem {

        public final  static String ERRO_ACESSO_BANCO = "ERRO AO ACESSAR BANCO DE DADOS - CONTACTAR O ADMIN";
        public final static String USUARIO_NAO_EXISTE = "USUARIO NÃO EXISTE";
        public final static String DADOS_INVALIDOS = "DADOS INVALIDOS";
        public final static String EMIAL_JA_CADASTRADO = "EMAIL JA CADASTRADO";


        public static void mensagemErro(String mensagemString) {
            // TODO Auto-generated method stub
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(mensagemString);
            alert.show();
        }

        public static void mensagemSucesso(String mensagemString) {
            // TODO Auto-generated method stub
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(mensagemString);
            alert.show();
        }

        public static void mensagemConfirmacao(String mensagemString) {
            // TODO Auto-generated method stub
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            Alert alert = new Alert (Alert.AlertType.WARNING);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(mensagemString);
            alert.show();
        }

}
