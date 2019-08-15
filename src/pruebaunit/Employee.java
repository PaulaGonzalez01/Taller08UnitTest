package pruebaunit;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Employee {   //remuneracion mensual unificada

    private final float rmu = 386;
    //salario del employee
    private float salary;
    private Currency currency;
    //porcentaje de bonus
    private float bonusPercentage;
    //variable de tipo employeeType
    private EmployeeType employeeType;

    public Employee(float salary, Currency currency,
            float bonusPercentage, EmployeeType employeeType) {
        this.salary = salary;
        this.currency = currency;
        this.bonusPercentage = bonusPercentage;
        this.employeeType = employeeType;
    }

    //calcula el salario dependiendo del tipo de trabajador 
    //y entrega el décimo correspondiente cada 2 meses
    public float cs() {
        Currency c = Currency.getInstance(Locale.US);
        float salario = 0;
        Date date = new Date();
        //Obtiene la hora local
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        //Obtiene el mes en forma de entero
        int month = localDate.getMonthValue();
        // Si la moneda es USD, se considera todo el salario,
        // caso contrario se resta 5% por cambio de moneda
        if (currency.equals(c)) {
            salario = salary;
        } else {
            salario =  (float) (salary * 0.95);
        }
        switch (employeeType) {
            case Worker:
                //Si el mes es impar entonces le entrega 
                //el décimo junto con su salario
                return month % 2 == 0 ? salario : salario + rmu / 12 * 2;
            case Supervisor:
                float valueS = salario + (bonusPercentage * 0.35F);
                //Si el mes es impar entonces le entrega 
                //el décimo junto con su salario y un bono
                return month % 2 == 0 ? valueS : valueS + rmu / 12 * 2;
            case Manager:
                float valueM = salario + (bonusPercentage * 0.7F);
                //Si el mes es impar entonces le entrega 
                //el décimo junto con su salario y un bono
                return month % 2 == 0 ? valueM : valueM + rmu / 12 * 2;
        }
        return 0.0F;
    }

    //calcula el bono de fin de año
    public float CalculateYearBonus() {
        Currency c = Currency.getInstance(Locale.US);

        float salario = 0;
        // Si la moneda es USD, se considera todo el salario,
        // caso contrario se resta 5% por cambio de moneda
        if (currency.equals(c)) {
            salario = salary;
        } else {
            salario = (float) (salary * 0.95);
        }
        switch (employeeType) {
            case Worker:
                return rmu;
            case Supervisor:
                return salario + rmu * 0.5F;
            case Manager:
                return salario + rmu * 1.0F;
        }
        return 0.0F;
    }
}
