package core.controllers.utils;

/**
 * Constantes para mensajes y demás.
 */
public final class MessageUtils {

    public static final String ID_STAND_INTEGER = "El ID del stand debe ser un número entero válido";
    public static final String PRICE_STAND_VALID = "El precio del stand debe ser un número válido";
    public static final String ID_STAND_INVALID = "El ID del stand no es válido";
    public static final String PRICE_STAND_POSITIVE = "El precio del stand debe ser mayor que cero";
    public static final String ID_STAND_EXISTS = "Ya existe un stand con ese ID";
    public static final String STAND_CREATED = "Stand creado correctamente";
    public static final String STAND_REQUIRED = "Debes seleccionar al menos un stand";
    public static final String STAND_ID_INVALID = "Uno de los IDs de stand no es válido";
    public static final String STAND_DUPLICATE = "No repitas stands en la misma compra";
    public static final String STAND_NOT_FOUND_ID = "El stand %s no existe";
    
    public static final String ID_PERSON_INTEGER = "El ID de la persona debe ser un número entero válido";
    public static final String ID_PERSON_INVALID = "El ID de la persona no es válido (debe ser >= 0 y tener máximo 15 dígitos)";
    public static final String NAME_REQUIRED = "El nombre y apellido son obligatorios";
    public static final String ID_PERSON_EXISTS = "Ya existe alguien registrado con ese ID";
    public static final String ROLE_REQUIRED = "Debes seleccionar un rol válido";
    public static final String ROLE_NOT_SUPPORTED = "Rol no soportado";
    public static final String PERSON_CREATED = "Persona creada correctamente";

    public static final String ID_MANAGER_INVALID = "El ID del gerente no es válido";
    public static final String MANAGER_NOT_FOUND = "El gerente seleccionado no existe";
    public static final String MANAGER_ASSIGNED = "Ese gerente ya está asignado a otra editorial";
    
    public static final String NIT_INVALID_FORMAT = "El NIT no cumple con el formato XXX.XXX.XXX-X";
    public static final String NAME_ADDRESS_REQUIRED = "Nombre y dirección son obligatorios";
    public static final String NIT_EXISTS = "Ya existe una editorial con ese NIT";
    public static final String PUBLISHER_CREATED = "Editorial creada correctamente";
    public static final String PUBLISHER_NOT_FOUND = "La editorial seleccionada no existe";
    public static final String PUBLISHER_REQUIRED = "Debes seleccionar al menos una editorial";
    public static final String PUBLISHER_DUPLICATE = "No repitas editoriales en la misma compra";
    public static final String NIT_INVALID = "Algunos NIT no son válidos";
    public static final String PUBLISHER_NOT_FOUND_NIT = "La editorial con NIT %s no existe";

    public static final String PRICE_BOOK_VALID = "El precio debe ser un número válido";
    public static final String PRICE_BOOK_POSITIVE = "El precio debe ser mayor que cero";
    public static final String TITLE_REQUIRED = "El título es obligatorio";
    public static final String ISBN_INVALID = "El ISBN no cumple con el formato XXX-X-XX-XXXXXX-X";
    public static final String ISBN_EXISTS = "Ya existe un libro con ese ISBN";
    public static final String TYPE_REQUIRED = "Debes seleccionar un tipo de libro";
    public static final String TYPE_NOT_SUPPORTED = "Tipo de libro no soportado";
    public static final String BOOK_CREATED = "Libro registrado correctamente";
    public static final String PAGES_COPIES_INTEGER = "Páginas y copias deben ser números enteros válidos";
    public static final String PAGES_COPIES_POSITIVE = "Páginas y copias deben ser mayores a cero";
    public static final String DURATION_NARRATOR_VALID = "Duración e ID de narrador deben ser números válidos";
    public static final String DURATION_POSITIVE = "La duración debe ser mayor que cero";
    
    public static final String AUTHOR_REQUIRED = "Debes seleccionar al menos un autor";
    public static final String AUTHOR_ID_INVALID = "Uno de los IDs de autor no es válido";
    public static final String AUTHOR_DUPLICATE = "No puedes repetir autores en el mismo libro";
    public static final String AUTHOR_NOT_FOUND = "Alguno de los autores no existe";
    public static final String AUTHOR_ID_NUMERIC = "El ID del autor debe ser un número válido";
    public static final String AUTHOR_ID_INVALID_RANGE = "El ID del autor no es válido";
    
    public static final String NARRATOR_REQUIRED = "Debe seleccionar un narrador";
    public static final String NARRATOR_NOT_FOUND = "El narrador seleccionado no existe";
    
    public static final String PURCHASE_SUCCESS = "Compra registrada correctamente";
    
    public static final String FORMAT_REQUIRED = "El formato es obligatorio";
    public static final String QUERY_BOOKS_BY_AUTHOR = "Libros por autor";
    public static final String QUERY_BOOKS_BY_FORMAT = "Libros por formato";
    public static final String QUERY_AUTHORS_TOP = "Autores destacados";

    private MessageUtils() {
        /*
        Siempre nuevo, así huele el ambientador (Eh)
        A 120 vuelo en el Aventador (Yeh-eh)
        No le vamo' a baja' el acelerador (Skrt), yeh
        Prendido sin encendedor (Yeah)

        [Coro]
        Lloviendo cash, baby, Saint Laurent, baby
        La Roleta con diamante' y el durag, baby
        Se pegan la' babie', ese flow, baby, yeh
        Yo sé que me siguen a mí
        Nos sobra el cash, baby, Saint Laurent, baby
        La Roleta con diamante' y el durag, baby
        Se pegan la' babie', ese flow, baby, yeh
        Yo sé que me siguen a mí (Yeh)

        [Verso]
        Mami me hizo bonito (Muah; sí)
        El flow desde chiquito, yeh, woh
        Alumbro como G-SHOCK, wow
        Los parties de jueve' a domingo, yeh
        Ahora tenemo' cuarto' (-to, -to)
        Flow bichote, pero no soy narco (No, no), yeh
        Ya pasamos el charco (Yeah)
        Si no contesto es porque estaba en el banco (¡Wuh!)

        [Puente]
        Sorry que te piché (-ché, -ché)
        La mala vibra tuya no la caché (-ché, -ché)
        Es que habían muchas chimbas esa noche
        Tengo a las mina' diciendome: "Parce" (Yo', eh, woh)
        Y no lo forcé (Woh, woh, woh), yeh (Trapperz)

        [Coro]
        Lloviendo cash, baby, Saint Laurent, baby
        La Roleta con diamante' y el durag, baby
        Se pegan la' babie', ese flow, baby, yeh (Yeah)
        Yo sé que me siguen a mí (Mí)
        Nos sobra el cash, baby, Saint Laurent, baby
        La Roleta con diamante' y el durag, baby
        Se pegan la' babie', ese flow, baby, yeh (Yo', ey, wow)
        Yo sé que me siguen a mí (Wow, wow; mí, mí)
        */
    }
}

