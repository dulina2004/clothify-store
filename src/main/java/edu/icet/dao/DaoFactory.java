package edu.icet.dao;
import edu.icet.dao.custom.impl.CustomerDaoImpl;
import edu.icet.dao.custom.impl.EmployeeDaoImpl;
import edu.icet.dao.custom.impl.ItemDaoImpl;
import edu.icet.dao.custom.impl.SupplierDaoImpl;
import edu.icet.util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance!=null?instance:(instance=new DaoFactory());
    }

    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case EMPLOYEE:return (T)new EmployeeDaoImpl();
            case CUSTOMER:return (T)new CustomerDaoImpl();
            case SUPPLIER:return (T)new SupplierDaoImpl();
            case ITEM:return (T)new ItemDaoImpl();
        }
        return null;
    }
}
