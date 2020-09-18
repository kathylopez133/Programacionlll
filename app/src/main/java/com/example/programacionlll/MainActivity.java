package com.example.programacionlll;


public class MainActivity {

    String [][] etiquetas = {
            {"Dolar","Euro", "Quetzal","Lempira","Colon Salvadoreño","Cordobas","Colon costarricense", "Peso colombiano", "yen japonés", "Corona noruega"},
            {"Libra","Gramos", "Kilogramos","Onzas","Quintal","Toneladas"},
            {"Metro","CM", "Pulgadas","Pies","Varas","Yardas","Kilometros", "Millas", },
            {"Megabyte", "Bit", "Byte", "KiloByte", "GigaByte", "TeraByte" },
            {"Hora", "Segundos", "Minutos", "Dias", "Semana", "Mes"},


    };
    Double [][] valores = {
            {1.0, 0.84, 7.73, 24.53, 8.71, 34.67, 593.20,715.12, 104.82, 9.04 },
            {1.0, 453.592, 0.453592, 0.16, 0.00453592 , 0.000453592},
            {1.0, 100.0, 39.3701, 3.28084, 1.1963081929167 , 1.09361, 0.001, 0.000621371},
            {1.0, 1.048576, 131.072, 128.0, 1.2*10-4 , 1.2*10-7},
            {1.0, 3.600, 0.60, 0.0416667, 0.00595238 , 0.001369861293303},


    };
    String[] obtenerConversor(int posicion){
        return etiquetas[posicion];
    }
    double convertir(int tipo, int de, int a, double cantidad){
        return valores[tipo][a] / valores[tipo][de] * cantidad;
    }
}
