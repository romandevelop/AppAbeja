package cl.gestiona.appabeja.model;

import java.util.ArrayList;
import java.util.List;

import cl.gestiona.appabeja.R;



public class FamiliaAbeja
{
    public int nombre;
    public int descricion;
    public int foto;
    private static ArrayList<FamiliaAbeja> list;
    public List<ItemAbeja> items;


    public FamiliaAbeja(int nombre, int descricion, int foto) {
        this.nombre = nombre;
        this.descricion = descricion;
        this.foto = foto;
        items = new ArrayList<>();
    }

    public static List<FamiliaAbeja> familiaList() {
        list = new ArrayList<>();
        //FAMILY OF BEE
        FamiliaAbeja collectidae = new FamiliaAbeja(R.string.colletidae_name, R.string.colletidae_descripcion, R.drawable.colletidae_app);
        FamiliaAbeja halictidae = new FamiliaAbeja(R.string.halictidae_name, R.string.halictidae_descripcion, R.drawable.halictidae_app);
        FamiliaAbeja apidae = new FamiliaAbeja(R.string.apidae_name, R.string.apidae_descripcion, R.drawable.apidae2_app);
        FamiliaAbeja megachilidae = new FamiliaAbeja(R.string.megachilidae_name, R.string.megachilidae_descripcion, R.drawable.megachilidae_app);
        FamiliaAbeja adrenidae = new FamiliaAbeja(R.string.adrenidae_name, R.string.adrenaide_descripcion, R.drawable.andrenidae_app);

        //Family collectidae
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Caupolicana_gayi, R.string.colletidae_Caupolicana_gayi_descripcion, R.drawable.fa_col_caupo_gayi, R.string.colletidae_Caupolicana_gayi_plantas));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Cadeguala_occidentalis, R.string.colletidae_Cadeguala_occidentalis_descripcion, R.drawable.fa_col_cad_occidentalis, R.string.colletidae_Cadeguala_occidentalis_plantas));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Colletes_seminitidus, R.string.colletidae_Colletes_seminitidus_descripcion, R.drawable.fa_col_colle_seminitidus, R.string.colletidae_Colletes_seminitidus_plantas));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Colletes_lucens, R.string.colletidae_Colletes_lucens_descripcion, R.drawable.fa_col_coll_lucens, R.string.colletidae_Colletes_lucens_plantas));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Chilicola_vernalis, R.string.colletidae_Chilicola_vernalis_descripcion, R.drawable.fa_col_chilicola_vernalis, R.string.colletidae_Chilicola_vernalis_plantas));

        //Family Halictidae
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Ruizanthedella_mutabilis, R.string.halictidae_Ruizanthedella_mutabilis_descripcion, R.drawable.fa_hal_ruiz_mutabilis, R.string.halictidae_Ruizanthedella_mutabilis_plantas));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Ruizanthedella_proxima, R.string.halictidae_Ruizanthedella_proxima_descripcion, R.drawable.fa_hal_ruiz_proxima, R.string.halictidae_Ruizanthedella_proxima_plantas));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Corynura_chloris, R.string.halictidae_Corynura_chloris_descripcion, R.drawable.fa_hal_cory_chloris, R.string.halictidae_Corynura_chloris_plantas));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Corynura_chilensis, R.string.halictidae_Corynura_chilensis_descripcion, R.drawable.fa_hal_cory_chilensis, R.string.halictidae_Corynura_chilensis_plantas));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Corynura_cristata, R.string.halictidae_Corynura_cristata_descripcion, R.drawable.fa_hal_cory_cristata, R.string.halictidae_Corynura_cristata_plantas));

        //Family adrenidae
        adrenidae.items.add(new ItemAbeja(R.string.adrenaide_Acamptopoeum_submetallicum, R.string.adrenaide_Acamptopoeum_submetallicum_descripcion, R.drawable.fa_acamsubm, R.string.adrenaide_Acamptopoeum_submetallicum_plantas));

        //Family megachilidae
        megachilidae.items.add(new ItemAbeja(R.string.megachilidae_Megachile_saulcyi, R.string.megachilidae_Megachile_saulcyi_descripcion, R.drawable.fa_meg_mega_saulcyi, R.string.megachilidae_Megachile_saulcyi_plantas));
        megachilidae.items.add(new ItemAbeja(R.string.megachilidae_Megachile_semirufa, R.string.megachilidae_Megachile_semirufa_descripcion, R.drawable.fa_meg_mega_semirufa, R.string.megachilidae_Megachile_semirufa_plantas));
        megachilidae.items.add(new ItemAbeja(R.string.megachilidae_Notanthidium_rudolphi, R.string.megachilidae_Notanthidium_rudolphi_descripcion, R.drawable.fa_meg_not_rudolphi, R.string.megachilidae_Notanthidium_rudolphi_plantas));

        //Family apidae
        apidae.items.add(new ItemAbeja(R.string.apidae_Allorscirtetica_gayi, R.string.apidae_Allorscirtetica_gayi_descripcion, R.drawable.fa_apiallogayi, R.string.apidae_Allorscirtetica_gayi_plantas));
        apidae.items.add(new ItemAbeja(R.string.apidae_Centris_cineraria, R.string.apidae_Centris_cineraria_descripcion, R.drawable.fa_api_ce_cineriaria, R.string.apidae_Centris_cineraria_plantas));
        apidae.items.add(new ItemAbeja(R.string.apidae_Centris_nigérrima, R.string.apidae_Centris_nigérrima_descripcion, R.drawable.fa_api_centris_nigerrima, R.string.apidae_Centris_nigérrima_plantas));
        apidae.items.add(new ItemAbeja(R.string.apidae_Diadasia_chilensis, R.string.apidae_Diadasia_chilensis_descripcion, R.drawable.fa_api_diadasia_chilensis, R.string.apidae_Diadasia_chilensis_plantas));
        apidae.items.add(new ItemAbeja(R.string.apidae_Manuelia_gayi, R.string.apidae_Manuelia_gayi_descripcion, R.drawable.fa_api_manuelia_gayi, R.string.apidae_Manuelia_gayi_plantas));

        list.add(adrenidae);
        list.add(apidae);
        list.add(collectidae);
        list.add(halictidae);
        list.add(megachilidae);

        return list;
    }
}



