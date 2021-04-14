package utils;

import java.util.Arrays;
import java.util.List;
import static com.app.core.AcType.*;
import static java.time.LocalDate.parse;


import com.app.core.BankAccount;

public interface CollectionUtils {
//add a static method to return fixed size populated list of banck accounts
	static List<BankAccount> populateAcctList() {
		return Arrays.asList(new BankAccount(10, "abc1", SAVING, 10000, parse("2020-01-19")),
				new BankAccount(100, "abc4", FD, 200000, parse("2019-01-19")),
				new BankAccount(34, "abc3", CURRENT, 5000, parse("2010-11-29")),
				new BankAccount(15, "abc6", SAVING, 12000, parse("2011-06-23")),
				new BankAccount(64, "abc8", SAVING, 9000, parse("2020-01-19")),
				new BankAccount(49, "abc2", DMAT, 13000, parse("2020-01-19"))
				);
	}
	//add a method to ret a populated growable hashmap from above sample data ??????
}
