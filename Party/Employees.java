
/**
 * @author Simon
 * @description this file is mainly deal with Employee, including table arrangement, etc.
 * @date 2023-01-19
 */

/**
 * There are also many getter and setter functions in this file, 
 * /which also split the data types in the List or Array list 
 * into the desired data types, and the data processing of the seats.
*/
public class Employees {
    private int companyId;
    private String name;
    /**
     * Table marking
     */
    private int table;
    /**
     * Mark the seat number
     */
    private int position;
    /**
     * Flags whether the location is arranged. The default is false
     */
    private boolean isArrange;
    public Employees() {
        //No seating is assigned by default
        this.table =-1;
        this.position=-1;
    }

    public boolean isArrange() {

        return isArrange;
    }

    public void setArrange(boolean arrange) {

        isArrange = arrange;
    }

    public Employees(int companyId, String name) {
        this.companyId = companyId;
        this.name = name;

    }

    public Integer getTable() { //getter

        return table;
    }

    public void setTable(int table) { //setter

        this.table = table;
    }

    public String getName() {

        return name;
    }

    public Integer getCompanyId() {

        return companyId;
    }

    public void setCompanyId(int companyId) {

        this.companyId = companyId;
    }

    public Integer getPosition() {

        return position;
    }

    public void setPosition(int position) {

        this.position = position;
    }

    public void setName(String name) {

        this.name = name;
    }
}
