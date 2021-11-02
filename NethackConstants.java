package me.djsch.Nethack;

public class NethackConstants {
    public static final int NUM_ROWS = 25;
    public static final int NUM_COLUMNS = 40;

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    // TODO probably need to update this to be some data structure with relative probability
    public static String[] potionAppearances = {
            "ruby",
            "pink",
            "orange",
            "yellow",
            "emerald",
            "dark green",
            "cyan",
            "sky blue",
            "brilliant blue",
            "magenta",
            "purple-red",
            "puce",
            "milky",
            "swirly",
            "bubbly",
            "smoky",
            "cloudy",
            "effervescent",
            "black",
            "golden",
            "brown",
            "fizzy",
            "dark",
            "white",
            "murky"
    };

    public static String[] potionTypes = {
            "booze",
            "fruit juice",
            "see invisible",
            "sickness",
            "confusion",
            "extra healing",
            "hallucination",
            "healing",
            "restore ability",
            "sleeping",
            "blindness",
            "gain energy",
            "invisibility",
            "monster detection",
            "object detection",
            "enlightenment",
            "full healing",
            "levitation",
            "polymorph",
            "speed",
            "acid",
            "oil",
            "gain ability",
            "gain level",
            "paralysis"
    };

    public static String[] scrollAppearances = {
            "ZELGO MER",
            "JUYED AWK YACC",
            "NR 9",
            "XIXAXA XOXAXA XUXAXA",
            "PRATYAVAYAH",
            "DAIYEN FOOELS",
            "LEP GEX VEN ZEA",
            "PRIRUTSENIE",
            "ELBIB YLOH",
            "VERR YED HORRE",
            "VENZAR BORGAVVE",
            "THARR",
            "YUM YUM",
            "KERNOD WEL",
            "ELAM EBOW",
            "DUAM XNAHT",
            "ANDOVA BEGARIN",
            "KIRJE",
            "VE FORBRYDERNE",
            "HACKEM MUCHE",
            "VELOX NEB",
            "FOOBIE BLETCH",
            "TEMOV",
            "GARVEN DEH",
            "READ ME",
            "ETAOIN SHRDLU",
            "LOREM IPSUM",
            "FNORD",
            "KO BATE",
            "ABRA KA DABRA",
            "ASHPD SODALG",
            "MAPIRO MAHAMA DIROMAT",
            "GNIK SISI VLE",
            "HAPAX LEGOMENON",
            "EIRIS SAZUN IDISI",
            "PHOL ENDE WODAN",
            "GHOTI",
            "ZLORFIK",
            "VAS CORP BET MANI",
            "STRC PRST SKRZ KRK",
            "XOR OTA"
    };

    public static String[] scrollTypes = {
            "identify",
            "light",
            "enchant weapon",
            "enchant armor",
            "remove curse",
            "confuse monster",
            "destroy armor",
            "fire",
            "food detection",
            "gold detection",
            "magic mapping",
            "scare monster",
            "teleportation",
            "amnesia",
            "create monster",
            "earth",
            "taming",
            "charging",
            "genocide",
            "punishment",
            "stinking cloud"
    };
}