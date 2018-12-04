/**
 * Provinces and Territories in Canada
 *
 * @author Mike M
 * @version 1.0
 */
public class Canada
{
    // Constants
    private static final int BC = 0;
    private static final int AB = 1;
    private static final int SK = 2;
    private static final int MB = 3;
    private static final int ON = 4;
    private static final int QC = 5;
    private static final int NB = 6;
    private static final int NS = 7;
    private static final int PE = 8;
    private static final int NL = 9;
    private static final int YK = 10;
    private static final int NT = 11;
    private static final int NV = 12;
    private static final int NUM_PROVINCES = 13;
    private static final int NO_SUCH_PROVINCE = -1;

    // Instance variables
    private ProvinceTerritory[] provinces;

    /**
     * Creates all the provinces and territories in Canada
     */
    public Canada() {

        // Initialize the array
        provinces = new ProvinceTerritory[NUM_PROVINCES];

        // Set the elements in the array
        provinces[BC] = new ProvinceTerritory("british columbia", 4400057);
        provinces[AB] = new ProvinceTerritory("alberta", 3645247);
        provinces[SK] = new ProvinceTerritory("saskatchewan", 1033381);
        provinces[MB] = new ProvinceTerritory("manitoba", 1208268);
        provinces[ON] = new ProvinceTerritory("ontario", 12851821);
        provinces[QC] = new ProvinceTerritory("quebec", 7903001);
        provinces[NB] = new ProvinceTerritory("new brunswick", 751171);
        provinces[NS] = new ProvinceTerritory("nova scotia", 921727);
        provinces[PE] = new ProvinceTerritory("prince edward island", 140204);
        provinces[NL] = new ProvinceTerritory("newfoundland and labrador", 514536);
        provinces[YK] = new ProvinceTerritory("yukon", 33897);
        provinces[NT] = new ProvinceTerritory("northwest territories", 41462);
        provinces[NV] = new ProvinceTerritory("nunavut", 31906);
    }

    /**
     * Gets the total population in Canada
     */
    public int getTotalPopulation() {

        int index = 0;
        int totalPopulation = 0;

        while(index < provinces.length) {
            totalPopulation += provinces[index].getPopulation();
            index++;
        }

        return totalPopulation;
    }

    /**
     * Gets the population of a province by name
     * 
     * @param province The name of the province for which to get the population
     * @return the province's population
     */
    public int getPopulation(String province) {

        if (null == province || province.equals("")) {
            throw new IllegalArgumentException("Invalid Province");
        }

        int index = 0;

        while(index < provinces.length) {

            if (province.equals(provinces[index].getName())) {
                return provinces[index].getPopulation();
            }
            index++;
        }

        return NO_SUCH_PROVINCE;
    }

    /**
     * Gets the lowest population province/territory in Canada
     * 
     * @return the name of the province with the lowest population
     */
    public String getLowestPopulation() {
        int index = 0;

        // Initialize to the population of the first province.
        // Could also set lowest Population to a very large value and the lowest name to null.
        int lowestPopulation = provinces[0].getPopulation();
        String lowestName = provinces[0].getName();

        while(index < provinces.length) {

            if (lowestPopulation >= provinces[index].getPopulation()) {
                lowestPopulation = provinces[index].getPopulation();
                lowestName = provinces[index].getName();
            }
            index++;
        }

        return lowestName;
    }

    /**
     * @return getProvincesWithPopulationBetween returns the names of all provinces/territories that have a population between min and max(inclusive)
     * @param min minimum population
     * @param max maximum population
     */
    public String[] getProvincesWithPopulationBetween(int min, int max) {
        int i = 0;
        int j = 0; // the new array index
        int numOfProvWithPop = 0;
        String[] matchingProvinces;

        while(i < provinces.length) {
            if((provinces[i].getPopulation() >= min) && (provinces[i].getPopulation() <= max)) {
                numOfProvWithPop++;
            }
            i++;
        }

        if(numOfProvWithPop > 0) {
            matchingProvinces = new String[numOfProvWithPop];
        }else{
            //no matches
            return null;
        }

        i = 0;   //Start looking from the beginning again
        while(i < provinces.length) {
            if((provinces[i].getPopulation() >= min) && (provinces[i].getPopulation() <= max)) {
                matchingProvinces[j] = provinces[i].getName();
                j++;
            }
            i++;
        }
        return matchingProvinces;
    }

    /**
     * @return isProvinceInCanada returns true if it is a province in canada else returns false
     * @param name name of the province
     */
    public boolean isProvinceInCanada(String name) {

        if(null == name || name.equals("")) {
            throw new IllegalArgumentException("Name must be set");   
        }

        int index = 0;

        while(index < provinces.length) {

            if(name.equals(provinces[index].getName())) {
                return true;
            }
            index++;
        }

        return false;
    }

    /**
     * @return getProvincesWhoseNameContains returns province which contains the parameter
     * @param substring name or subname of provinces
     */
    public String[] getProvincesWhoseNameContains(String substring) {

        if(null == substring || substring.equals("")) {
            throw new IllegalArgumentException("substring must be set");
        }

        int i = 0;
        int j = 0;
        int numOfProvContaining = 0;
        String[] containingProvinces;

        while(i < provinces.length) {
            if(provinces[i].getName().toLowerCase().contains(substring.toLowerCase())) {
                numOfProvContaining++;
            }
            i++;
        }

        if(numOfProvContaining > 0) {
            containingProvinces = new String[numOfProvContaining];
        }else{
            //no matches
            return null;
        }

        i = 0;   //Start looking from the beginning again
        while(i < provinces.length) {
            if(provinces[i].getName().toLowerCase().contains(substring.toLowerCase())) {
                containingProvinces[j] = provinces[i].getName();
                j++;
            }
            i++;
        }
        return containingProvinces;
    }

    /**
     * @return getMoreProvincesWhoseNameContains returns provinces whose name contains the substring
     * @param substring name or subname of province
     */
    public ProvinceTerritory[] getMoreProvincesWhoseNameContains(String substring) {

        if(null == substring || substring.equals("")) {
            throw new IllegalArgumentException("substring must be set");
        }

        int i = 0;
        int j = 0;
        int numOfProvContaining = 0;
        
        ProvinceTerritory[] provinceTerritory;

        while(i < provinces.length) {
            if(provinces[i].getName().toLowerCase().contains(substring.toLowerCase())) {
                numOfProvContaining++;
            }
            i++;
        }

        if(numOfProvContaining > 0) {
            provinceTerritory = new ProvinceTerritory[numOfProvContaining];
        }else{
            //no matches
            return null;
        }

        i = 0;   //Start looking from the beginning again
        while(i < provinces.length) {
            if(provinces[i].getName().toLowerCase().contains(substring.toLowerCase())) {
                provinceTerritory[j] = provinces[i];
                j++;
            }
            i++;
        }
        return provinceTerritory;

           
    }

    public String[] getProvincesWhoseNameStartsWith(char letter) {
        return null;
    }
}