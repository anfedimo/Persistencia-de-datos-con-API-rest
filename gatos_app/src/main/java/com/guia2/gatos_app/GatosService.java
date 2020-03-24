/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guia2.gatos_app;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Pro
 */
public class GatosService {
    
    public static void verGatos() throws IOException{
        // 1. vamos a traer los datos de la API

        OkHttpClient client = new OkHttpClient();
        
        Request request = new Request.Builder().url("https://cdn2.thecatapi.com/images/1be.jpg").get().build();

        Response response = client.newCall(request).execute(); 
        
        String elJson = response.body().string();
        
        //cortar los corchetes
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);
        
        //crear objeto de la clase Gson
        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);
        
        //redimensionar en caso de necesitar
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);
            
            ImageIcon fondoGato = new ImageIcon(image);
            
            if(fondoGato.getIconWidth() > 800){
                //redimensionamos 
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificada);
            }
            
            String menu = "opciones:  \n"
                    + "1. Ver otra imagen \n"
                    + "2. Favorito \n"
                    + "3. Volver \n";
         
            String [] botones = {"ver otra imagen", "favorito", "volver"};
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, menu, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0] );
            
            int seleccion = -1;
            //validamos que opcion selecciona el usuario
                 for(int i=0;i<botones.length;i++){
                    if(opcion.equals(botones[i])){
                        seleccion = i;  
                         }
                     }
                        switch (seleccion){
                            case 0:
                                verGatos();
                                break;
                            case 1:
                                favoritoGato(gatos);
                                break;
                            default:
                                break;         
                        }
            
        }catch (IOException e) {
            System.out.println(e);
        }
        
      
        
    }
    
    public static void favoritoGato(Gatos gato) {
        
    } 
    
}
