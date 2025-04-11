package com.ander.aplicacioniniciativas.Activities;

import com.ander.aplicacioniniciativas.Models.Indicador;

import java.util.ArrayList;
import java.util.List;

public class ServiceIndicadores {

    public static List<Indicador> getIndicadores() {
        List<Indicador> listIndicadores = new ArrayList<>();

        listIndicadores.add(new Indicador(1, "Qué iniciativas se han realizado dirigidas a los ODS por curso académico"));
        listIndicadores.add(new Indicador(2, "Qué iniciativas se han realizado dirigidas a los ODS por curso académico"));
        listIndicadores.add(new Indicador(3, "En qué ciclo se han realizado las iniciativas, proyectos, y en los ciclos qué módulos han intervenido"));
        listIndicadores.add(new Indicador(4, "En qué consiste cada acción, proyecto, iniciativa y si hay un producto final"));
        listIndicadores.add(new Indicador(5, "A qué ODS va dirigida cada acción y dentro de cada ODS a qué metas concretas"));
        listIndicadores.add(new Indicador(6, "Si en la realización del proyecto, acción ha colaborado alguna entidad externa"));
        listIndicadores.add(new Indicador(7, "Si las acciones, proyectos se han difundido"));
        listIndicadores.add(new Indicador(8, "Diferenciar si son Proyectos, charlas o talleres"));
        listIndicadores.add(new Indicador(9, "Cada ODS, y por lo tanto cada proyecto, charla, etc, está vinculada a una dimensión"));
        listIndicadores.add(new Indicador(10, "Personas que han sido responsables de las iniciativas, proyectos, etc."));
        listIndicadores.add(new Indicador(11, "De las acciones realizadas cuales son nuevas, innovadoras o que han hecho alguna modificación importante"));
        listIndicadores.add(new Indicador(12, "Cuánto tiempo se ha dedicado a cada acción"));
        listIndicadores.add(new Indicador(13, "Si esas acciones o proyectos han requerido de alguna visita, salida, charla, etc."));

        return listIndicadores;
    }
}
