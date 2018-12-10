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
        FamiliaAbeja apidae = new FamiliaAbeja(R.string.apidae_name, R.string.apidae_descripcion, R.drawable.fa_api_manuelia_gayi);
        FamiliaAbeja megachilidae = new FamiliaAbeja(R.string.megachilidae_name, R.string.megachilidae_descripcion, R.drawable.fa_meg_mega_saulcyi);
        FamiliaAbeja adrenidae = new FamiliaAbeja(R.string.adrenidae_name, R.string.adrenaide_descripcion, R.drawable.andrenidae_app);

        //Family collectidae
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Caupolicana_gayi, R.string.colletidae_Caupolicana_gayi_descripcion, R.drawable.fa_col_caupo_gayi, R.string.colletidae_Caupolicana_gayi_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_solanum_ligustrinum_name, R.string.nativa, R.string.nat_solanum_ligustrinum_descripcion, R.drawable.na_solanum),
                new ItemFlower(R.string.nat_aristotelia_chilensis_name, R.string.nativa, R.string.nat_aristotelia_chilensis_descripcion, R.drawable.na_aristotelia),
                new ItemFlower(R.string.nat_guindilia_trinervis_name, R.string.nativa, R.string.nat_guindilia_trinervis_descripcion, R.drawable.na_guindilia)
        }));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Cadeguala_occidentalis, R.string.colletidae_Cadeguala_occidentalis_descripcion, R.drawable.fa_col_cad_occidentalis, R.string.colletidae_Cadeguala_occidentalis_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_adesmia_angustifolia_name, R.string.nativa, R.string.nat_adesmia_angustifolia_descripcion, R.drawable.na_adesmia),
                new ItemFlower(R.string.nat_eryngium_paniculatum_name, R.string.nativa, R.string.nat_eryngium_paniculatum_descripcion, R.drawable.na_eryngium),
                new ItemFlower(R.string.en_lithrea_caustica_name, R.string.endemica, R.string.en_lithrea_caustica_descripcion, R.drawable.en_lithrea),
                new ItemFlower(R.string.nat_lomatia_hirsuta_name, R.string.nativa, R.string.nat_lomatia_hirsuta_descripcion, R.drawable.na_lomatia),
                new ItemFlower(R.string.nat_pasithaea_coerulea_name, R.string.nativa, R.string.nat_pasithaea_coerulea_descripcion, R.drawable.na_pasithaea)

        }));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Colletes_seminitidus, R.string.colletidae_Colletes_seminitidus_descripcion, R.drawable.fa_col_colle_seminitidus, R.string.colletidae_Colletes_seminitidus_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_maytenus_boaria_name, R.string.nativa, R.string.nat_maytenus_boaria_descripcion, R.drawable.na_maytenus),
                new ItemFlower(R.string.ex_persea_americana_name, R.string.exotica, R.string.ex_persea_americana_descripcion, R.drawable.ex_persea),
                new ItemFlower(R.string.nat_schinus_latifolius_name, R.string.nativa, R.string.nat_schinus_latifolius_descripcion, R.drawable.na_schinus),
                new ItemFlower(R.string.nat_lomatia_hirsuta_name, R.string.nativa, R.string.nat_lomatia_hirsuta_descripcion, R.drawable.na_lomatia),
                new ItemFlower(R.string.en_lithrea_caustica_name, R.string.endemica, R.string.en_lithrea_caustica_descripcion, R.drawable.en_lithrea)
        }));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Colletes_lucens, R.string.colletidae_Colletes_lucens_descripcion, R.drawable.fa_col_coll_lucens, R.string.colletidae_Colletes_lucens_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.nat_haplopapus_sp_name, R.string.nativa, R.string.nat_haplopapus_sp_descripcion, R.drawable.na_haplopapus),
                new ItemFlower(R.string.ex_taraxacum_officinale_name, R.string.exotica, R.string.ex_taraxacum_officinale_descripcion, R.drawable.ex_taraxacum)
        }));
        collectidae.items.add(new ItemAbeja(R.string.colletidae_Chilicola_vernalis, R.string.colletidae_Chilicola_vernalis_descripcion, R.drawable.fa_col_chilicola_vernalis, R.string.colletidae_Chilicola_vernalis_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.nat_maytenus_boaria_name, R.string.nativa, R.string.nat_maytenus_boaria_descripcion, R.drawable.na_maytenus),
                new ItemFlower(R.string.en_oxalis_rosea_name, R.string.endemica, R.string.en_oxalis_rosea_descripcion, R.drawable.en_oxalis)
        }));

        //Family Halictidae
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Ruizanthedella_mutabilis, R.string.halictidae_Ruizanthedella_mutabilis_descripcion, R.drawable.fa_hal_ruiz_mutabilis, R.string.halictidae_Ruizanthedella_mutabilis_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.nat_pasithaea_coerulea_name, R.string.nativa, R.string.nat_pasithaea_coerulea_descripcion, R.drawable.na_pasithaea),
                new ItemFlower(R.string.nat_schinus_latifolius_name, R.string.nativa, R.string.nat_schinus_latifolius_descripcion, R.drawable.na_schinus),
                new ItemFlower(R.string.en_quillaja_saponaria_name, R.string.endemica, R.string.en_quillaja_saponaria_descripcion, R.drawable.en_quillaja)
        }));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Ruizanthedella_proxima, R.string.halictidae_Ruizanthedella_proxima_descripcion, R.drawable.fa_hal_ruiz_proxima, R.string.halictidae_Ruizanthedella_proxima_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.nat_schinus_latifolius_name, R.string.nativa, R.string.nat_schinus_latifolius_descripcion, R.drawable.na_schinus),
                new ItemFlower(R.string.en_quillaja_saponaria_name, R.string.endemica, R.string.en_quillaja_saponaria_descripcion, R.drawable.en_quillaja),
                new ItemFlower(R.string.ex_brassica_campestris_name, R.string.exotica, R.string.ex_brassica_campestris_descripcion, R.drawable.ex_brassica)
        }));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Corynura_chloris, R.string.halictidae_Corynura_chloris_descripcion, R.drawable.fa_hal_cory_chloris, R.string.halictidae_Corynura_chloris_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.en_quillaja_saponaria_name, R.string.endemica, R.string.en_quillaja_saponaria_descripcion, R.drawable.en_quillaja),
                new ItemFlower(R.string.nat_schinus_latifolius_name, R.string.nativa, R.string.nat_schinus_latifolius_descripcion, R.drawable.na_schinus),
                new ItemFlower(R.string.nat_maytenus_boaria_name, R.string.nativa, R.string.nat_maytenus_boaria_descripcion, R.drawable.na_maytenus),
                new ItemFlower(R.string.en_peumus_boldo_name, R.string.endemica, R.string.en_peumus_boldo_descripcion, R.drawable.en_boldus),
                new ItemFlower(R.string.ex_persea_americana_name, R.string.exotica, R.string.ex_persea_americana_descripcion, R.drawable.ex_persea),
                new ItemFlower(R.string.nat_guindilia_trinervis_name, R.string.nativa, R.string.nat_guindilia_trinervis_descripcion, R.drawable.na_guindilia)
        }));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Corynura_chilensis, R.string.halictidae_Corynura_chilensis_descripcion, R.drawable.fa_hal_cory_chilensis, R.string.halictidae_Corynura_chilensis_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_eryngium_paniculatum_name, R.string.nativa, R.string.nat_eryngium_paniculatum_descripcion, R.drawable.na_eryngium),
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.nat_schinus_latifolius_name, R.string.nativa, R.string.nat_schinus_latifolius_descripcion, R.drawable.na_schinus),
                new ItemFlower(R.string.ex_persea_americana_name, R.string.exotica, R.string.ex_persea_americana_descripcion, R.drawable.ex_persea)
        }));
        halictidae.items.add(new ItemAbeja(R.string.halictidae_Corynura_cristata, R.string.halictidae_Corynura_cristata_descripcion, R.drawable.fa_hal_cory_cristata, R.string.halictidae_Corynura_cristata_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_maytenus_boaria_name, R.string.nativa, R.string.nat_maytenus_boaria_descripcion, R.drawable.na_maytenus),
                new ItemFlower(R.string.nat_retanilla_trinervia_name, R.string.nativa, R.string.nat_retanilla_trinervia_descripcion, R.drawable.na_retanilla),
                new ItemFlower(R.string.nat_guindilia_trinervis_name, R.string.nativa, R.string.nat_guindilia_trinervis_descripcion, R.drawable.na_guindilia)

        }));

        //Family adrenidae
        adrenidae.items.add(new ItemAbeja(R.string.adrenaide_Acamptopoeum_submetallicum, R.string.adrenaide_Acamptopoeum_submetallicum_descripcion, R.drawable.fa_acamsubm, R.string.adrenaide_Acamptopoeum_submetallicum_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_eryngium_paniculatum_name, R.string.nativa, R.string.nat_eryngium_paniculatum_descripcion, R.drawable.na_eryngium),
                new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis),
                new ItemFlower(R.string.nat_haplopapus_sp_name, R.string.nativa, R.string.nat_haplopapus_sp_descripcion, R.drawable.na_haplopapus),
                new ItemFlower(R.string.ex_taraxacum_officinale_name, R.string.exotica, R.string.ex_taraxacum_officinale_descripcion, R.drawable.ex_taraxacum)

        }));

        //Family megachilidae
        megachilidae.items.add(new ItemAbeja(R.string.megachilidae_Megachile_saulcyi, R.string.megachilidae_Megachile_saulcyi_descripcion, R.drawable.fa_meg_mega_saulcyi, R.string.megachilidae_Megachile_saulcyi_plantas,new ItemFlower[]{
                new ItemFlower(R.string.en_alstroemeria_ligtu_name, R.string.endemica, R.string.en_alstroemeria_ligtu_descripcion, R.drawable.en_alstroemeria),
                new ItemFlower(R.string.ex_galega_officinalis_name, R.string.exotica, R.string.ex_galega_officinalis_descripcion, R.drawable.ex_galega),
                new ItemFlower(R.string.ex_echium_vulgare_name, R.string.exotica, R.string.ex_echium_vulgare_descripcion, R.drawable.ex_echium)
        }));
        megachilidae.items.add(new ItemAbeja(R.string.megachilidae_Megachile_semirufa, R.string.megachilidae_Megachile_semirufa_descripcion, R.drawable.fa_meg_mega_semirufa, R.string.megachilidae_Megachile_semirufa_plantas,new ItemFlower[]{
                new ItemFlower(R.string.en_alstroemeria_ligtu_name, R.string.endemica, R.string.en_alstroemeria_ligtu_descripcion, R.drawable.en_alstroemeria),
                new ItemFlower(R.string.nat_adesmia_angustifolia_name, R.string.nativa, R.string.nat_adesmia_angustifolia_descripcion, R.drawable.na_adesmia),
                new ItemFlower(R.string.nat_phacelia_secunda_name, R.string.nativa, R.string.nat_phacelia_secunda_descripcion, R.drawable.na_phacelia)
        }));
        megachilidae.items.add(new ItemAbeja(R.string.megachilidae_Notanthidium_rudolphi, R.string.megachilidae_Notanthidium_rudolphi_descripcion, R.drawable.fa_meg_not_rudolphi, R.string.megachilidae_Notanthidium_rudolphi_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_adesmia_angustifolia_name, R.string.nativa, R.string.nat_adesmia_angustifolia_descripcion, R.drawable.na_adesmia),
                new ItemFlower(R.string.en_malesherbia_linearifolia_name, R.string.endemica, R.string.en_malesherbia_linearifolia_descripcion, R.drawable.en_malesherbia)
        }));

        //Family apidae
        apidae.items.add(new ItemAbeja(R.string.apidae_Allorscirtetica_gayi, R.string.apidae_Allorscirtetica_gayi_descripcion, R.drawable.fa_apiallogayi, R.string.apidae_Allorscirtetica_gayi_plantas,new ItemFlower[]{
                new ItemFlower(R.string.en_alstroemeria_ligtu_name, R.string.endemica, R.string.en_alstroemeria_ligtu_descripcion, R.drawable.en_alstroemeria),
                new ItemFlower(R.string.nat_loasa_tricolor_name, R.string.nativa, R.string.nat_loasa_tricolor_descripcion, R.drawable.na_loasa),

        }));
        apidae.items.add(new ItemAbeja(R.string.apidae_Centris_cineraria, R.string.apidae_Centris_cineraria_descripcion, R.drawable.fa_api_ce_cineriaria, R.string.apidae_Centris_cineraria_plantas,new ItemFlower[]{
                new ItemFlower(R.string.nat_adesmia_angustifolia_name, R.string.nativa, R.string.nat_adesmia_angustifolia_descripcion, R.drawable.na_adesmia)

        }));
        apidae.items.add(new ItemAbeja(R.string.apidae_Centris_nigérrima, R.string.apidae_Centris_nigérrima_descripcion, R.drawable.fa_api_centris_nigerrima, R.string.apidae_Centris_nigérrima_plantas,new ItemFlower[]{
                new ItemFlower(R.string.en_alstroemeria_ligtu_name, R.string.endemica, R.string.en_alstroemeria_ligtu_descripcion, R.drawable.en_alstroemeria),
                new ItemFlower(R.string.en_chloraea_bletioides_name, R.string.endemica, R.string.en_chloraea_bletioides_descripcion, R.drawable.en_chloraea)

        }));
        apidae.items.add(new ItemAbeja(R.string.apidae_Diadasia_chilensis, R.string.apidae_Diadasia_chilensis_descripcion, R.drawable.fa_api_diadasia_chilensis, R.string.apidae_Diadasia_chilensis_plantas,new ItemFlower[]{
                new ItemFlower(R.string.ex_brassica_campestris_name, R.string.exotica, R.string.ex_brassica_campestris_descripcion, R.drawable.ex_brassica),
                new ItemFlower(R.string.ex_galega_officinalis_name, R.string.exotica, R.string.ex_galega_officinalis_descripcion, R.drawable.ex_galega)
        }));
        apidae.items.add(new ItemAbeja(R.string.apidae_Manuelia_gayi, R.string.apidae_Manuelia_gayi_descripcion, R.drawable.fa_api_manuelia_gayi, R.string.apidae_Manuelia_gayi_plantas,new ItemFlower[]{
                new ItemFlower(R.string.en_puya_coerulea_name, R.string.endemica, R.string.en_puya_coerulea_descripcion, R.drawable.en_puya),
                new ItemFlower(R.string.en_alstroemeria_ligtu_name, R.string.endemica, R.string.en_alstroemeria_ligtu_descripcion, R.drawable.en_alstroemeria),
                new ItemFlower(R.string.nat_eccremocarpus_scaber_name, R.string.nativa, R.string.nat_eccremocarpus_scaber_descripcion, R.drawable.na_eccremocarpus)
        }));


        list.add(adrenidae);
        list.add(apidae);
        list.add(collectidae);
        list.add(halictidae);
        list.add(megachilidae);

        return list;
    }





    public static List<ItemFlower> flowerList(){
        ArrayList<ItemFlower> list = new ArrayList<>();

        list.add(new ItemFlower(R.string.nat_adesmia_angustifolia_name, R.string.nativa, R.string.nat_adesmia_angustifolia_descripcion, R.drawable.na_adesmia));
        list.add(new ItemFlower(R.string.nat_aristotelia_chilensis_name, R.string.nativa, R.string.nat_aristotelia_chilensis_descripcion, R.drawable.na_aristotelia));
        list.add(new ItemFlower(R.string.nat_baccharis_sp_name, R.string.nativa, R.string.nat_baccharis_sp_descripcion, R.drawable.na_baccharis));
        list.add(new ItemFlower(R.string.nat_eccremocarpus_scaber_name, R.string.nativa, R.string.nat_eccremocarpus_scaber_descripcion, R.drawable.na_eccremocarpus));
        list.add(new ItemFlower(R.string.nat_eryngium_paniculatum_name, R.string.nativa, R.string.nat_eryngium_paniculatum_descripcion, R.drawable.na_eryngium));
        list.add(new ItemFlower(R.string.nat_guindilia_trinervis_name, R.string.nativa, R.string.nat_guindilia_trinervis_descripcion, R.drawable.na_guindilia));
        list.add(new ItemFlower(R.string.nat_haplopapus_sp_name, R.string.nativa, R.string.nat_haplopapus_sp_descripcion, R.drawable.na_haplopapus));
        list.add(new ItemFlower(R.string.nat_loasa_tricolor_name, R.string.nativa, R.string.nat_loasa_tricolor_descripcion, R.drawable.na_loasa));
        list.add(new ItemFlower(R.string.nat_lomatia_hirsuta_name, R.string.nativa, R.string.nat_lomatia_hirsuta_descripcion, R.drawable.na_lomatia));
        list.add(new ItemFlower(R.string.nat_maytenus_boaria_name, R.string.nativa, R.string.nat_maytenus_boaria_descripcion, R.drawable.na_maytenus));
        list.add(new ItemFlower(R.string.nat_pasithaea_coerulea_name, R.string.nativa, R.string.nat_pasithaea_coerulea_descripcion, R.drawable.na_pasithaea));
        list.add(new ItemFlower(R.string.nat_phacelia_secunda_name, R.string.nativa, R.string.nat_phacelia_secunda_descripcion, R.drawable.na_phacelia));
        list.add(new ItemFlower(R.string.nat_retanilla_trinervia_name, R.string.nativa, R.string.nat_retanilla_trinervia_descripcion, R.drawable.na_retanilla));
        list.add(new ItemFlower(R.string.nat_schinus_latifolius_name, R.string.nativa, R.string.nat_schinus_latifolius_descripcion, R.drawable.na_schinus));
        list.add(new ItemFlower(R.string.nat_solanum_ligustrinum_name, R.string.nativa, R.string.nat_solanum_ligustrinum_descripcion, R.drawable.na_solanum));


        list.add(new ItemFlower(R.string.ex_brassica_campestris_name, R.string.exotica, R.string.ex_brassica_campestris_descripcion, R.drawable.ex_brassica));
        list.add(new ItemFlower(R.string.ex_echium_vulgare_name, R.string.exotica, R.string.ex_echium_vulgare_descripcion, R.drawable.ex_echium));
        list.add(new ItemFlower(R.string.ex_galega_officinalis_name, R.string.exotica, R.string.ex_galega_officinalis_descripcion, R.drawable.ex_galega));
        list.add(new ItemFlower(R.string.ex_persea_americana_name, R.string.exotica, R.string.ex_persea_americana_descripcion, R.drawable.ex_persea));
        list.add(new ItemFlower(R.string.ex_taraxacum_officinale_name, R.string.exotica, R.string.ex_taraxacum_officinale_descripcion, R.drawable.ex_taraxacum));


        list.add(new ItemFlower(R.string.en_alstroemeria_ligtu_name, R.string.endemica, R.string.en_alstroemeria_ligtu_descripcion, R.drawable.en_alstroemeria));
        list.add(new ItemFlower(R.string.en_chloraea_bletioides_name, R.string.endemica, R.string.en_chloraea_bletioides_descripcion, R.drawable.en_chloraea));
        list.add(new ItemFlower(R.string.en_lithrea_caustica_name, R.string.endemica, R.string.en_lithrea_caustica_descripcion, R.drawable.en_lithrea));
        list.add(new ItemFlower(R.string.en_malesherbia_linearifolia_name, R.string.endemica, R.string.en_malesherbia_linearifolia_descripcion, R.drawable.en_malesherbia));
        list.add(new ItemFlower(R.string.en_oxalis_rosea_name, R.string.endemica, R.string.en_oxalis_rosea_descripcion, R.drawable.en_oxalis));
        list.add(new ItemFlower(R.string.en_peumus_boldo_name, R.string.endemica, R.string.en_peumus_boldo_descripcion, R.drawable.en_boldus));
        list.add(new ItemFlower(R.string.en_puya_coerulea_name, R.string.endemica, R.string.en_puya_coerulea_descripcion, R.drawable.en_puya));
        list.add(new ItemFlower(R.string.en_quillaja_saponaria_name, R.string.endemica, R.string.en_quillaja_saponaria_descripcion, R.drawable.en_quillaja));




        return list;



    }

}



