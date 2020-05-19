package fr.goyet;

import java.io.IOException;

import fr.goyet.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CFunApp extends Application{
	
	private static Scene scene;						// Variable de la scene graphique en static
	private static BorderPane menu;					// Variable de la bordure de la scene en static (le menu)
	private final String TITRE = "Complexe CFun";	// Titre de l'application
	private Stage primaryStage;						// Variable de 

	
	// Point d'entrée de l'application
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle(TITRE);		// Définition du titre de la fenêtre de l'application
		// Définition de l'icone de la fenêtre d'application
		this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resource/CFUN_logo.png")));
		try {
			initMenu();							// Initialisation du menu
			
			
			primaryStage.setScene(scene);		// Création de la scène
			primaryStage.show();				// Affichage de la fenêtre
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Affiche une vue
	public static void afficheVue(String uneVue) throws IOException {
		Parent root = FXMLLoader.load(CFunApp.class.getResource(uneVue));
		menu.setCenter(root);		// Centre la vue en dessous du menu
		
	}
	
	// Initialisation du menu
	public void initMenu() throws Exception {
		FXMLLoader loader = new FXMLLoader();		// Création d'un FXMLLoader
		loader.setLocation(CFunApp.class.getResource("view/View_Menu.fxml"));
		try {
			menu = (BorderPane) loader.load();
			Parent root = FXMLLoader.load(CFunApp.class.getResource("View/View_Accueil.fxml"));
			menu.setCenter(root);
			
			MenuController controller = loader.getController();
			controller.setCFunApp(this);
			
			scene = new Scene(menu);

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}