package implementPayroll;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
class ManageData{

	static ArrayList<Employee> data = new ArrayList<Employee>();

	ManageData(){
		//weekly paid, member of union
		Employee e1 = new Employee("Jay",123);
		e1.last_paid = Calendar.getInstance();
		e1.last_paid.set(2020,5,8);
		e1.p = new DailyEmployee(100);
		e1.u = new MemberOfUnion(200);
		e1.m = new Paymaster();
		// e.p = payable;
		// e.u = unionmembership;
		// e.m = method;
		data.add(e1);


		//weekly paid, not in union
		Employee e2 = new Employee("Veeru",124);
		e2.last_paid = Calendar.getInstance();
		e2.last_paid.set(2020,5,8);
		e2.p = new DailyEmployee(110);
		e2.u  = new NotMemberOfUnion();
		e2.m  = new BankAccount();
		// e.p = payable;
		// e.u = unionmembership;
		// e.m = method;
		data.add(e2);


		//monthly paid, member of union
		Employee e3 = new Employee("Basanti",53);
		e3.last_paid = Calendar.getInstance();
		e3.last_paid.set(2020,5,8);
		e3.p = new MonthlyEmployee(20000,10);
		e3.u  = new MemberOfUnion(200);
		e3.m  = new Paymaster();
		// e.p = payable;
		// e.u = unionmembership;
		// e.m = method;
		data.add(e3);



		//monthly paid, not in union
		Employee e4 = new Employee("Mausi",140);
		e4.last_paid = Calendar.getInstance();
		e4.last_paid.set(2020,5,1);
		e4.p = new MonthlyEmployee(25000,8);
		e4.u = new NotMemberOfUnion();
		e4.m = new Mail();
		// e.p = payable;
		// e.u = unionmembership;
		// e.m = method;
		data.add(e4);





	}

	void add_to_database(Employee emp){
		data.add(emp);
	}


	void delete_from_database(int empid){
		for(Employee e : data)
		{
			if (e.employee_id == empid)
				data.remove(e);
				break;
		}
	}


	Employee retrieve_from_database(int empid){
		for(Employee e : data)
		{
			if (e.employee_id == empid)
				return e;
		}
		return null;

	}

	void modify_database(int empid, Employee new_emp){
		for(Employee e : data)
		{
			if (e.employee_id == empid)
				{
					data.remove(e);
					data.add(new_emp);
					break;
				}
		}
	}


}
