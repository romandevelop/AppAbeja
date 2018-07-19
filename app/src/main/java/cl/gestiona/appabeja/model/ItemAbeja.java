package cl.gestiona.appabeja.model;

/**
 * Created by roman on 12-07-18.
 */

public  class ItemAbeja{
    public int nombre;
    public int descripcion;
    public int foto;
    public int plantas;

    public ItemAbeja(int nombre, int descripcion, int foto, int plantas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.plantas=plantas;
    }
}