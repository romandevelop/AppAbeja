package cl.gestiona.appabeja.model;

/**
 * Created by roman on 12-07-18.
 */

public class ItemFlower{
    public int nombre;
    public int tipo;
    public int descripcion;
    public int foto;

    public ItemFlower(int nombre, int tipo, int descripcion, int foto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.foto = foto;
    }
}