package core.controllers.dto;

public class PublisherTableDto {

    private final String nit;
    private final String name;
    private final String address;
    private final String managerName;
    private final int standQuantity;

    public PublisherTableDto(String nit, String name, String address, String managerName, int standQuantity) {
        this.nit = nit;
        this.name = name;
        this.address = address;
        this.managerName = managerName;
        this.standQuantity = standQuantity;
    }

    public String getNit() {
        return nit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getManagerName() {
        return managerName;
    }

    /*
    No sé qué es lo que me falta
    Porque, mami, tengo tu amor
    Ahora siento tu amor

    No sé qué es lo que me falta
    Porque, mami, tengo tu amor
    Ahora siento tu amor

    Vino a sacarse su mambo
    Se fue más triste que un tango
    Yo no puedo pensar tanto
    Por eso siempre le canto

    Me gasto toa la plata en el bar (bar)
    Me escondo como sol en el mar (sol en el mar)
    Soy dulce pero suelto mi sal (sal)
    Me quiere pero yo le hago mal (yo le hago mal)

    Ahora que la cosa viene bien (bien)
    Ando relajao con mi gang (gang)
    Y es que nunca le perdí la fe (la fe)
    Noche larga, litros de café

    Le agarré gustito al fajo (ey)
    Sin estudio ni trabajo
    Porque yo agarré el atajo
    Y la hicimo desde abajo (real shit)

    Todos me buscan como a Wall-E (como a Wall-E)
    Porque la vaina tiene quali (quali)
    Quiero valijas con money, ey
    Para llevarle a mi mami (ey)

    No sé qué es lo que me falta
    Porque, mami, tengo tu amor
    Ahora siento tu amor

    No sé qué es lo que me falta
    Porque, mami, tengo tu amor
    Ahora siento tu amor, eh

    Tengo más fuego que tú
    Hielo en el cuello, un iglú
    Sueno más fuego que tú
    Paco rompiendo en club
    Llevo los pesos pal blue, yah

    Yey-yeah-yeah
    ¡Chi!
    Eh, eh, eh
    */

    public int getStandQuantity() {
        return standQuantity;
    }
}
