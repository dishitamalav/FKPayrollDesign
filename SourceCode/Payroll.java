package implementPayroll;

import java.math.BigDecimal;
import java.util.ArrayList;

interface Payable{
	
	BigDecimal get_salary_to_pay();

	void get_sales_receipt();

	void get_time_card();
}

class DailyEmployee implements Payable{
	DailyEmployee(double hourly_rate){
		String s=String.valueOf(hourly_rate); 
		this.hourly_rate = new BigDecimal(s);
		temp_salary= new BigDecimal("0");
	}
	BigDecimal hourly_rate;
	BigDecimal temp_salary;
	public void get_time_card(){
		
	}


	public void get_sales_receipt(){
		//do nothing.	
	}

	public BigDecimal get_salary_to_pay(){
		return new BigDecimal("0");	}

}




class MonthlyEmployee implements Payable{
	MonthlyEmployee(double flat_salary,double commission_rate){
		String s=String.valueOf(flat_salary); 
		this.flat_salary = new BigDecimal(s);
		s=String.valueOf(commission_rate); 
		this.commission_rate = new BigDecimal(s);
		temp_commission = new BigDecimal("0");
	}
	BigDecimal flat_salary;
	BigDecimal commission_rate;
	BigDecimal temp_commission;
	public void get_sales_receipt(){
		//to input sales amount 
	
		//commission*amt - run if get_sales_receipt
	}

	public void get_time_card(){
		//do nothing.
	}


	public BigDecimal get_salary_to_pay(){
		return new BigDecimal("0");
	}


}


interface UnionMembership{
	
	BigDecimal calculate_final_salary();

}

class MemberOfUnion implements UnionMembership{
	MemberOfUnion(){
		weekly_dues = new BigDecimal("0");
		service_charges = new BigDecimal("0");
		
	}
	BigDecimal weekly_dues;
	BigDecimal service_charges;
	public BigDecimal calculate_final_salary(){
		return new BigDecimal("0");
	}
}

class NotMemberOfUnion implements UnionMembership{
	public BigDecimal calculate_final_salary(){
		return new BigDecimal("0");
	}
}



interface MethodOfPayment{
	// Bigdecimal salary(Payable p, UnionMembership u){
	// 	BigDecimal first_caluclation = p.get_salary_to_pay()
	// }
	void pay(BigDecimal amount);
}

class Mail implements MethodOfPayment{
	public void pay(BigDecimal amount){
		System.out.println("Mailed Rs "+amount+" to registered postal address");
	}
}

class Paymaster implements MethodOfPayment{
	public void pay(BigDecimal amount){
		System.out.println("Rs "+amount+" is held by postmaster for collection");
	}
}

class BankAccount implements MethodOfPayment{
	public void pay(BigDecimal amount){
		System.out.println("Transferred Rs "+amount+" to registered bank account");
	}
}


class Employee{
	Employee(String employee_name,int employee_id){
		this.employee_name = employee_name;
		this.employee_id = employee_id;
	}
	String employee_name;
	int employee_id;

	Payable p;
	UnionMembership u;

	MethodOfPayment m;

	// void run_payroll(){
		
	// }

}





public class Payroll{
	
	void execute_payroll(){

	}

	public static void main(String[] args) {
      //System.out.println("Classes defined, functions not defined");
  		
  		ManageData db = new ManageData();
  		System.out.println("Database initialised");
  		  		
	}
}


// class ManageData{

// 	ArrayList<Employee> data = new ArrayList<Employee>();

// 	ManageData(){
// 		//weekly paid, member of union
// 		Employee e1 = new Employee("Jay",123);
// 		e1.p = new DailyEmployee(100);
// 		e1.u = new MemberOfUnion();
// 		e1.m = new Paymaster();
// 		// e.p = payable;
// 		// e.u = unionmembership;
// 		// e.m = method;
// 		data.add(e1);


// 		//weekly paid, not in union
// 		Employee e2 = new Employee("Veeru",124);
// 		e2.p = new DailyEmployee(110);
// 		e2.u  = new NotMemberOfUnion();
// 		e2.m  = new BankAccount();
// 		// e.p = payable;
// 		// e.u = unionmembership;
// 		// e.m = method;
// 		data.add(e2);


// 		//monthly paid, member of union
// 		Employee e3 = new Employee("Basanti",53);
// 		e3.p = new MonthlyEmployee(20000,10);
// 		e3.u  = new MemberOfUnion();
// 		e3.m  = new Paymaster();
// 		// e.p = payable;
// 		// e.u = unionmembership;
// 		// e.m = method;
// 		data.add(e3);



// 		//monthly paid, not in union
// 		Employee e4 = new Employee("Mausi",140);
// 		e4.p = new MonthlyEmployee(25000,8);
// 		e4.u = new NotMemberOfUnion();
// 		e4.m = new Mail();
// 		// e.p = payable;
// 		// e.u = unionmembership;
// 		// e.m = method;
// 		data.add(e4);





// 	}

// 	void add_to_database(Employee emp){
// 		data.add(emp);
// 	}


// 	void delete_from_database(int empid){
// 		for(Employee e : data)
// 		{
// 			if (e.employee_id == empid)
// 				data.remove(e);
// 		}
// 	}


// 	Employee retrieve_from_database(int empid){
// 		for(Employee e : data)
// 		{
// 			if (e.employee_id == empid)
// 				return e;
// 		}
// 		return null;

// 	}

// 	void modify_database(int empid, Employee new_emp){
// 		for(Employee e : data)
// 		{
// 			if (e.employee_id == empid)
// 				{
// 					data.remove(e);
// 					data.add(new_emp);
// 					break;
// 				}
// 		}
// 	}


// }



// create database employeepayroll;
// use employeepayroll;
// create table emp(name varchar(40), id int(10), isWeekly boolean, isMember boolean, hourlyRate BigDecimal, flatSalary BigDecimal, commissionRate BigDecimal, dues BigDecimal, serviceCharges BigDecimal, temp BigDecimal);


									



