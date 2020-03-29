package newDynamic;

class StringNode
{
	String data;
	StringNode right;
	StringNode left;
	StringNode(String data)
	{
		this.data = data;
		this.right = null;
		this.left = null;
	}
	public StringNode() {
		// TODO Auto-generated constructor stub
	}
}
public class EvaluationOfExpressionTree {
	int evaluate(StringNode root)
	{
		if(root== null)
			return 0;
		if(root.right == null && root.left == null)
		{
			return Integer.parseInt(root.data);
		}
		else
		{
			int res = 0;
			int lEval = evaluate(root.left);
			int rEval = evaluate(root.right);
			if(root.data == "+")
			{
				res = lEval + rEval;
			}
			if(root.data == "-")
			{
				res = lEval - rEval;
			}
			if(root.data == "*")
			{
				res = lEval * rEval;
			}
			if(root.data == "/")
			{
				res = lEval / rEval;
			}
			return res;
		}
	}
	public static void main(String[] args) {
		EvaluationOfExpressionTree obj = new EvaluationOfExpressionTree();
		StringNode root = new StringNode("+");
	    root.left = new StringNode("*");
	    root.left.left = new StringNode("5");
	    root.left.right = new StringNode("4");
	    root.right = new StringNode("-");
	    root.right.left = new StringNode("100");
	    root.right.right = new StringNode("20");
	    System.out.println(obj.evaluate(root));
	    
	}
}
