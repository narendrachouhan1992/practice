package Entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Exceptions.BankingException;
import Exceptions.NoBranchExistException;
import Status.Status;
import utils.BankUtils;

public class HeadOffice {
	Map<String , Branch> branches;
	public List<Branch> getAllBranches() {
		return  branches.values().stream().map(s->{
			try {
				return s.getCopy();
			} catch (BankingException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());
	}
	public Branch getBranchByBranchID(String id) throws BankingException
	{
		if(branches.containsKey(id))
			return branches.get(id);
		throw new NoBranchExistException("No branch found with ID:"+id);
	}
	public Status createBranch()
	{
		String branchID = BankUtils.getInstance().generateUniqueBranchNum();
		Branch b = new Branch(branchID);
		branches.put(b.getBranchID(), b);
		System.out.println("branch created with ID:"+branchID);
		return Status.SUCCESS;
	}
	public HeadOffice() {
		branches = new HashMap<String, Branch>();
	}
	@Override
	public String toString() {
		return "HeadOffice [branches=" + branches + "]";
	}
}
