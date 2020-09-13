package HackerRank.dictionaryHashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queries {
	static List<Integer> freqQuery1(List<List<Integer>> queries) {
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		
		for (List<Integer> query : queries) {
			int num = query.get(1);
			if(query.get(0)==1)
			{
				if(numMap.containsKey(num))
				{
					numMap.put(num, numMap.get(num)+1);
				}
				else
					numMap.put(num, 1);
			}
			else if(query.get(0)==2)
			{
				if(!numMap.containsKey(num))
					continue;
				else if (numMap.get(num)>1)
					numMap.put(num, numMap.get(num)-1);
				else
					numMap.remove(num);
			}
			else if(query.get(0)==3)
			{
				if(numMap.containsValue(num))
					res.add(1);
				else
					res.add(0);
			}
		}
		
		return res;
	}
	static List<Integer> freqQuery2(List<List<Integer>> queries) {
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		freqMap.put(0, 0);
		for (List<Integer> query : queries) {
			int num = query.get(1);
			if(query.get(0)==1)
			{
				if(numMap.containsKey(num))
				{
					int freq = numMap.get(num);
					numMap.put(num, freq+1);
					freqMap.put(freq, freqMap.get(freq)-1);
					int newFreq = freqMap.get(freq+1)==null?0:freqMap.get(freq+1);
					freqMap.put(freq+1, newFreq+1);
				}
				else
				{
					numMap.put(num, 1);
					int newFreq = freqMap.get(1)==null?0:freqMap.get(1);
					freqMap.put(1, newFreq+1);
				}
			}
			else if(query.get(0)==2)
			{
				if(!numMap.containsKey(num) || numMap.get(num)==0)
					continue;
				else
				{
					int freq = numMap.get(num);
					numMap.put(num, numMap.get(num)-1);
					freqMap.put(freq, freqMap.get(freq)-1);
					freqMap.put(freq-1, freqMap.get(freq-1)+1);
				}
			}
			else if(query.get(0)==3)
			{
				if(freqMap.get(num)==null || freqMap.get(num)==0)
					res.add(0);
				else
					res.add(1);
			}
		}
		
		return res;
	}
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> res = new ArrayList<Integer>();
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		freqMap.put(0, 0);
		try
		{
			for (List<Integer> query : queries) {
				int num = query.get(1);
				if(query.get(0)==1)
				{
					if(numMap.containsKey(num))
					{
						int freq = numMap.get(num);
						numMap.put(num, freq+1);
						freqMap.put(freq, freqMap.get(freq)-1);
						int newFreq = freqMap.get(freq+1)==null?0:freqMap.get(freq+1);
						freqMap.put(freq+1, newFreq+1);
					}
					else
					{
						numMap.put(num, 1);
						int newFreq = freqMap.get(1)==null?0:freqMap.get(1);
						freqMap.put(1, newFreq+1);
					}
				}
				else if(query.get(0)==2)
				{
					if(!numMap.containsKey(num) || numMap.get(num)==0)
						continue;
					else
					{
						int freq = numMap.get(num);
						numMap.put(num, numMap.get(num)-1);
						freqMap.put(freq, freqMap.get(freq)-1);
						freqMap.put(freq-1, freqMap.get(freq-1)+1);
					}
				}
				else if(query.get(0)==3)
				{
					if(freqMap.get(num)==null || freqMap.get(num)==0)
						res.add(0);
					else
						res.add(1);
				}
			}
		}
		catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Integer a1[]={1,624};Integer a2[]={1,980};Integer a3[]={2,18};Integer a4[]={2,13};Integer a5[]={2,1};Integer a6[]={2,3};Integer a7[]={1,887};Integer a8[]={1,184};Integer a9[]={3,2};Integer a10[]={2,17};Integer a11[]={2,10};Integer a12[]={2,1};Integer a13[]={2,19};Integer a14[]={1,763};Integer a15[]={2,20};Integer a16[]={1,476};Integer a17[]={2,6};Integer a18[]={2,1};Integer a19[]={2,3};Integer a20[]={1,994};Integer a21[]={3,9};Integer a22[]={1,155};Integer a23[]={2,7};Integer a24[]={3,14};Integer a25[]={3,6};Integer a26[]={1,495};Integer a27[]={1,226};Integer a28[]={2,1};Integer a29[]={3,20};Integer a30[]={1,434};Integer a31[]={2,13};Integer a32[]={2,3};Integer a33[]={1,414};Integer a34[]={2,2};Integer a35[]={1,576};Integer a36[]={2,6};Integer a37[]={3,4};Integer a38[]={2,14};Integer a39[]={3,1};Integer a40[]={3,18};Integer a41[]={3,10};Integer a42[]={1,31};Integer a43[]={1,638};Integer a44[]={2,8};Integer a45[]={2,5};Integer a46[]={3,9};Integer a47[]={3,3};Integer a48[]={1,751};Integer a49[]={2,1};Integer a50[]={2,18};Integer a51[]={2,16};Integer a52[]={1,229};Integer a53[]={3,4};Integer a54[]={3,2};Integer a55[]={1,354};Integer a56[]={2,9};Integer a57[]={3,8};Integer a58[]={1,580};Integer a59[]={1,421};Integer a60[]={3,7};Integer a61[]={1,365};Integer a62[]={1,434};Integer a63[]={1,370};Integer a64[]={2,10};Integer a65[]={2,15};Integer a66[]={2,17};Integer a67[]={1,116};Integer a68[]={2,11};Integer a69[]={3,10};Integer a70[]={3,8};Integer a71[]={1,220};Integer a72[]={3,20};Integer a73[]={2,10};Integer a74[]={3,9};Integer a75[]={2,19};Integer a76[]={3,15};Integer a77[]={2,17};Integer a78[]={1,674};Integer a79[]={1,617};Integer a80[]={3,9};Integer a81[]={3,3};Integer a82[]={2,12};Integer a83[]={1,437};Integer a84[]={3,6};Integer a85[]={1,973};Integer a86[]={2,10};Integer a87[]={2,6};Integer a88[]={1,81};Integer a89[]={2,1};Integer a90[]={2,6};Integer a91[]={3,7};Integer a92[]={1,86};Integer a93[]={2,19};Integer a94[]={1,228};Integer a95[]={2,15};Integer a96[]={1,566};Integer a97[]={3,16};Integer a98[]={3,2};Integer a99[]={2,8};Integer a100[]={2,6};Integer a101[]={2,10};Integer a102[]={1,967};Integer a103[]={2,17};Integer a104[]={3,11};Integer a105[]={1,527};Integer a106[]={1,747};Integer a107[]={1,905};Integer a108[]={2,3};Integer a109[]={2,20};Integer a110[]={1,521};Integer a111[]={3,3};Integer a112[]={1,442};Integer a113[]={2,4};Integer a114[]={3,19};Integer a115[]={1,967};Integer a116[]={3,17};Integer a117[]={2,20};Integer a118[]={2,4};Integer a119[]={3,9};Integer a120[]={2,1};Integer a121[]={2,10};Integer a122[]={2,7};Integer a123[]={2,18};Integer a124[]={3,20};Integer a125[]={3,15};Integer a126[]={3,12};Integer a127[]={2,17};Integer a128[]={2,10};Integer a129[]={3,6};Integer a130[]={1,724};Integer a131[]={1,287};Integer a132[]={3,7};Integer a133[]={1,42};Integer a134[]={3,15};Integer a135[]={3,17};Integer a136[]={1,920};Integer a137[]={3,2};Integer a138[]={3,2};Integer a139[]={1,342};Integer a140[]={2,1};Integer a141[]={3,14};Integer a142[]={3,16};Integer a143[]={3,15};Integer a144[]={2,18};Integer a145[]={3,14};Integer a146[]={1,893};Integer a147[]={2,6};Integer a148[]={2,6};Integer a149[]={3,17};Integer a150[]={1,986};Integer a151[]={1,638};Integer a152[]={1,66};Integer a153[]={1,832};Integer a154[]={2,15};Integer a155[]={2,17};Integer a156[]={1,906};Integer a157[]={2,6};Integer a158[]={3,14};Integer a159[]={3,8};Integer a160[]={2,11};Integer a161[]={1,529};Integer a162[]={1,494};Integer a163[]={2,17};Integer a164[]={3,3};Integer a165[]={1,109};Integer a166[]={1,966};Integer a167[]={1,842};Integer a168[]={3,2};Integer a169[]={1,247};Integer a170[]={1,536};Integer a171[]={2,2};Integer a172[]={1,752};Integer a173[]={1,211};Integer a174[]={2,8};Integer a175[]={1,841};Integer a176[]={2,17};Integer a177[]={3,1};Integer a178[]={2,18};Integer a179[]={1,662};Integer a180[]={2,9};Integer a181[]={1,823};Integer a182[]={1,299};Integer a183[]={1,106};Integer a184[]={2,15};Integer a185[]={3,13};Integer a186[]={2,2};Integer a187[]={2,12};Integer a188[]={1,290};Integer a189[]={2,7};Integer a190[]={2,19};Integer a191[]={3,13};Integer a192[]={2,16};Integer a193[]={1,965};Integer a194[]={1,481};Integer a195[]={1,190};Integer a196[]={1,425};Integer a197[]={3,6};Integer a198[]={3,11};Integer a199[]={1,246};Integer a200[]={1,44};Integer a201[]={3,18};Integer a202[]={1,199};Integer a203[]={1,796};Integer a204[]={2,1};Integer a205[]={2,7};Integer a206[]={2,8};Integer a207[]={3,17};Integer a208[]={2,19};Integer a209[]={2,6};Integer a210[]={3,10};Integer a211[]={1,187};Integer a212[]={2,8};Integer a213[]={1,800};Integer a214[]={1,292};Integer a215[]={1,654};Integer a216[]={3,4};Integer a217[]={3,13};Integer a218[]={3,6};Integer a219[]={3,5};Integer a220[]={2,20};Integer a221[]={3,16};Integer a222[]={1,337};Integer a223[]={1,527};Integer a224[]={3,20};Integer a225[]={2,10};Integer a226[]={2,16};Integer a227[]={3,4};Integer a228[]={1,615};Integer a229[]={2,18};Integer a230[]={1,669};Integer a231[]={2,19};Integer a232[]={2,8};Integer a233[]={1,868};Integer a234[]={1,806};Integer a235[]={1,848};Integer a236[]={3,6};Integer a237[]={2,5};Integer a238[]={3,16};Integer a239[]={1,444};Integer a240[]={3,2};Integer a241[]={3,17};Integer a242[]={3,10};Integer a243[]={2,10};Integer a244[]={3,16};Integer a245[]={3,1};Integer a246[]={3,15};Integer a247[]={2,11};Integer a248[]={1,145};Integer a249[]={3,20};Integer a250[]={2,15};Integer a251[]={2,16};Integer a252[]={2,16};Integer a253[]={3,4};Integer a254[]={3,2};Integer a255[]={1,927};Integer a256[]={3,13};Integer a257[]={3,9};Integer a258[]={1,351};Integer a259[]={1,59};Integer a260[]={1,799};Integer a261[]={2,11};Integer a262[]={3,9};Integer a263[]={3,6};Integer a264[]={1,590};Integer a265[]={3,6};Integer a266[]={3,5};Integer a267[]={3,15};Integer a268[]={2,11};Integer a269[]={3,12};Integer a270[]={2,18};Integer a271[]={2,12};Integer a272[]={3,8};Integer a273[]={1,607};Integer a274[]={1,13};Integer a275[]={3,15};Integer a276[]={1,879};Integer a277[]={2,8};Integer a278[]={2,5};Integer a279[]={2,16};Integer a280[]={1,879};Integer a281[]={1,251};Integer a282[]={2,11};Integer a283[]={3,6};Integer a284[]={1,174};Integer a285[]={1,765};Integer a286[]={1,733};Integer a287[]={3,18};Integer a288[]={1,465};Integer a289[]={2,3};Integer a290[]={1,677};Integer a291[]={3,3};Integer a292[]={1,805};Integer a293[]={3,5};Integer a294[]={3,20};Integer a295[]={1,395};Integer a296[]={3,11};Integer a297[]={3,4};Integer a298[]={1,929};Integer a299[]={1,693};Integer a300[]={3,15};Integer a301[]={3,7};Integer a302[]={3,4};Integer a303[]={3,14};Integer a304[]={1,865};Integer a305[]={1,749};Integer a306[]={2,8};Integer a307[]={1,96};Integer a308[]={3,8};Integer a309[]={2,4};Integer a310[]={1,471};Integer a311[]={3,6};Integer a312[]={2,15};Integer a313[]={2,1};Integer a314[]={3,4};Integer a315[]={3,20};Integer a316[]={3,17};Integer a317[]={1,856};Integer a318[]={1,718};Integer a319[]={1,182};Integer a320[]={2,10};Integer a321[]={1,394};Integer a322[]={1,444};Integer a323[]={2,14};Integer a324[]={1,490};Integer a325[]={3,4};Integer a326[]={3,8};Integer a327[]={1,460};Integer a328[]={3,19};Integer a329[]={1,769};Integer a330[]={1,504};Integer a331[]={1,266};Integer a332[]={1,675};Integer a333[]={1,888};Integer a334[]={1,699};Integer a335[]={1,891};Integer a336[]={2,8};Integer a337[]={3,7};Integer a338[]={2,6};Integer a339[]={1,75};Integer a340[]={1,330};Integer a341[]={2,16};Integer a342[]={1,392};Integer a343[]={3,16};Integer a344[]={1,409};Integer a345[]={1,515};Integer a346[]={3,16};Integer a347[]={1,125};Integer a348[]={1,370};Integer a349[]={3,13};Integer a350[]={2,6};Integer a351[]={2,11};Integer a352[]={1,818};Integer a353[]={2,2};Integer a354[]={1,105};Integer a355[]={2,7};Integer a356[]={2,5};Integer a357[]={1,944};Integer a358[]={2,19};Integer a359[]={2,15};Integer a360[]={2,12};Integer a361[]={2,2};Integer a362[]={2,20};Integer a363[]={2,18};Integer a364[]={3,1};Integer a365[]={2,11};Integer a366[]={3,1};Integer a367[]={1,848};Integer a368[]={1,717};Integer a369[]={2,6};Integer a370[]={2,14};Integer a371[]={2,18};Integer a372[]={1,774};Integer a373[]={2,6};Integer a374[]={1,654};Integer a375[]={2,2};Integer a376[]={2,12};Integer a377[]={1,361};Integer a378[]={3,18};Integer a379[]={3,2};Integer a380[]={1,433};Integer a381[]={1,316};Integer a382[]={1,264};Integer a383[]={1,250};Integer a384[]={3,17};Integer a385[]={3,20};Integer a386[]={2,16};Integer a387[]={1,93};Integer a388[]={3,4};Integer a389[]={1,26};Integer a390[]={3,7};Integer a391[]={2,7};Integer a392[]={3,8};Integer a393[]={1,499};Integer a394[]={1,817};Integer a395[]={3,20};Integer a396[]={3,9};Integer a397[]={1,797};Integer a398[]={1,708};Integer a399[]={2,17};Integer a400[]={3,14};Integer a401[]={3,13};Integer a402[]={1,26};Integer a403[]={3,7};Integer a404[]={2,18};Integer a405[]={2,11};Integer a406[]={2,20};Integer a407[]={1,882};Integer a408[]={3,11};Integer a409[]={1,78};Integer a410[]={1,135};Integer a411[]={3,15};Integer a412[]={2,5};Integer a413[]={2,18};Integer a414[]={2,4};Integer a415[]={2,1};Integer a416[]={1,118};Integer a417[]={1,332};Integer a418[]={3,13};Integer a419[]={2,13};Integer a420[]={2,9};Integer a421[]={3,11};Integer a422[]={3,19};Integer a423[]={2,16};Integer a424[]={2,1};Integer a425[]={3,15};Integer a426[]={1,568};Integer a427[]={1,501};Integer a428[]={1,823};Integer a429[]={2,15};Integer a430[]={3,17};Integer a431[]={3,17};Integer a432[]={2,19};Integer a433[]={3,15};Integer a434[]={3,3};Integer a435[]={1,309};Integer a436[]={2,17};Integer a437[]={2,15};Integer a438[]={2,10};Integer a439[]={2,8};Integer a440[]={1,24};Integer a441[]={3,4};Integer a442[]={2,14};Integer a443[]={3,8};Integer a444[]={3,1};Integer a445[]={3,10};Integer a446[]={2,8};Integer a447[]={3,18};Integer a448[]={2,1};Integer a449[]={2,12};Integer a450[]={2,10};Integer a451[]={1,621};Integer a452[]={1,974};Integer a453[]={1,181};Integer a454[]={2,17};Integer a455[]={2,15};Integer a456[]={2,7};Integer a457[]={3,4};Integer a458[]={1,415};Integer a459[]={2,10};Integer a460[]={3,10};Integer a461[]={3,4};Integer a462[]={3,18};Integer a463[]={1,480};Integer a464[]={3,10};Integer a465[]={2,12};Integer a466[]={2,8};Integer a467[]={2,6};Integer a468[]={1,86};Integer a469[]={3,17};Integer a470[]={3,13};Integer a471[]={1,109};Integer a472[]={1,300};Integer a473[]={1,319};Integer a474[]={1,228};Integer a475[]={3,1};Integer a476[]={2,8};Integer a477[]={3,7};Integer a478[]={3,10};Integer a479[]={3,8};Integer a480[]={1,38};Integer a481[]={2,12};Integer a482[]={3,20};Integer a483[]={2,4};Integer a484[]={3,12};Integer a485[]={2,16};Integer a486[]={1,278};Integer a487[]={2,10};Integer a488[]={2,11};Integer a489[]={1,44};Integer a490[]={2,19};Integer a491[]={1,472};Integer a492[]={1,939};Integer a493[]={1,616};Integer a494[]={2,12};Integer a495[]={3,8};Integer a496[]={3,20};Integer a497[]={3,11};Integer a498[]={1,574};Integer a499[]={3,5};Integer a500[]={1,68};
		list.add(Arrays.asList(a1));list.add(Arrays.asList(a2));list.add(Arrays.asList(a3));list.add(Arrays.asList(a4));list.add(Arrays.asList(a5));list.add(Arrays.asList(a6));list.add(Arrays.asList(a7));list.add(Arrays.asList(a8));list.add(Arrays.asList(a9));list.add(Arrays.asList(a10));list.add(Arrays.asList(a11));list.add(Arrays.asList(a12));list.add(Arrays.asList(a13));list.add(Arrays.asList(a14));list.add(Arrays.asList(a15));list.add(Arrays.asList(a16));list.add(Arrays.asList(a17));list.add(Arrays.asList(a18));list.add(Arrays.asList(a19));list.add(Arrays.asList(a20));list.add(Arrays.asList(a21));list.add(Arrays.asList(a22));list.add(Arrays.asList(a23));list.add(Arrays.asList(a24));list.add(Arrays.asList(a25));list.add(Arrays.asList(a26));list.add(Arrays.asList(a27));list.add(Arrays.asList(a28));list.add(Arrays.asList(a29));list.add(Arrays.asList(a30));list.add(Arrays.asList(a31));list.add(Arrays.asList(a32));list.add(Arrays.asList(a33));list.add(Arrays.asList(a34));list.add(Arrays.asList(a35));list.add(Arrays.asList(a36));list.add(Arrays.asList(a37));list.add(Arrays.asList(a38));list.add(Arrays.asList(a39));list.add(Arrays.asList(a40));list.add(Arrays.asList(a41));list.add(Arrays.asList(a42));list.add(Arrays.asList(a43));list.add(Arrays.asList(a44));list.add(Arrays.asList(a45));list.add(Arrays.asList(a46));list.add(Arrays.asList(a47));list.add(Arrays.asList(a48));list.add(Arrays.asList(a49));list.add(Arrays.asList(a50));list.add(Arrays.asList(a51));list.add(Arrays.asList(a52));list.add(Arrays.asList(a53));list.add(Arrays.asList(a54));list.add(Arrays.asList(a55));list.add(Arrays.asList(a56));list.add(Arrays.asList(a57));list.add(Arrays.asList(a58));list.add(Arrays.asList(a59));list.add(Arrays.asList(a60));list.add(Arrays.asList(a61));list.add(Arrays.asList(a62));list.add(Arrays.asList(a63));list.add(Arrays.asList(a64));list.add(Arrays.asList(a65));list.add(Arrays.asList(a66));list.add(Arrays.asList(a67));list.add(Arrays.asList(a68));list.add(Arrays.asList(a69));list.add(Arrays.asList(a70));list.add(Arrays.asList(a71));list.add(Arrays.asList(a72));list.add(Arrays.asList(a73));list.add(Arrays.asList(a74));list.add(Arrays.asList(a75));list.add(Arrays.asList(a76));list.add(Arrays.asList(a77));list.add(Arrays.asList(a78));list.add(Arrays.asList(a79));list.add(Arrays.asList(a80));list.add(Arrays.asList(a81));list.add(Arrays.asList(a82));list.add(Arrays.asList(a83));list.add(Arrays.asList(a84));list.add(Arrays.asList(a85));list.add(Arrays.asList(a86));list.add(Arrays.asList(a87));list.add(Arrays.asList(a88));list.add(Arrays.asList(a89));list.add(Arrays.asList(a90));list.add(Arrays.asList(a91));list.add(Arrays.asList(a92));list.add(Arrays.asList(a93));list.add(Arrays.asList(a94));list.add(Arrays.asList(a95));list.add(Arrays.asList(a96));list.add(Arrays.asList(a97));list.add(Arrays.asList(a98));list.add(Arrays.asList(a99));list.add(Arrays.asList(a100));list.add(Arrays.asList(a101));list.add(Arrays.asList(a102));list.add(Arrays.asList(a103));list.add(Arrays.asList(a104));list.add(Arrays.asList(a105));list.add(Arrays.asList(a106));list.add(Arrays.asList(a107));list.add(Arrays.asList(a108));list.add(Arrays.asList(a109));list.add(Arrays.asList(a110));list.add(Arrays.asList(a111));list.add(Arrays.asList(a112));list.add(Arrays.asList(a113));list.add(Arrays.asList(a114));list.add(Arrays.asList(a115));list.add(Arrays.asList(a116));list.add(Arrays.asList(a117));list.add(Arrays.asList(a118));list.add(Arrays.asList(a119));list.add(Arrays.asList(a120));list.add(Arrays.asList(a121));list.add(Arrays.asList(a122));list.add(Arrays.asList(a123));list.add(Arrays.asList(a124));list.add(Arrays.asList(a125));list.add(Arrays.asList(a126));list.add(Arrays.asList(a127));list.add(Arrays.asList(a128));list.add(Arrays.asList(a129));list.add(Arrays.asList(a130));list.add(Arrays.asList(a131));list.add(Arrays.asList(a132));list.add(Arrays.asList(a133));list.add(Arrays.asList(a134));list.add(Arrays.asList(a135));list.add(Arrays.asList(a136));list.add(Arrays.asList(a137));list.add(Arrays.asList(a138));list.add(Arrays.asList(a139));list.add(Arrays.asList(a140));list.add(Arrays.asList(a141));list.add(Arrays.asList(a142));list.add(Arrays.asList(a143));list.add(Arrays.asList(a144));list.add(Arrays.asList(a145));list.add(Arrays.asList(a146));list.add(Arrays.asList(a147));list.add(Arrays.asList(a148));list.add(Arrays.asList(a149));list.add(Arrays.asList(a150));list.add(Arrays.asList(a151));list.add(Arrays.asList(a152));list.add(Arrays.asList(a153));list.add(Arrays.asList(a154));list.add(Arrays.asList(a155));list.add(Arrays.asList(a156));list.add(Arrays.asList(a157));list.add(Arrays.asList(a158));list.add(Arrays.asList(a159));list.add(Arrays.asList(a160));list.add(Arrays.asList(a161));list.add(Arrays.asList(a162));list.add(Arrays.asList(a163));list.add(Arrays.asList(a164));list.add(Arrays.asList(a165));list.add(Arrays.asList(a166));list.add(Arrays.asList(a167));list.add(Arrays.asList(a168));list.add(Arrays.asList(a169));list.add(Arrays.asList(a170));list.add(Arrays.asList(a171));list.add(Arrays.asList(a172));list.add(Arrays.asList(a173));list.add(Arrays.asList(a174));list.add(Arrays.asList(a175));list.add(Arrays.asList(a176));list.add(Arrays.asList(a177));list.add(Arrays.asList(a178));list.add(Arrays.asList(a179));list.add(Arrays.asList(a180));list.add(Arrays.asList(a181));list.add(Arrays.asList(a182));list.add(Arrays.asList(a183));list.add(Arrays.asList(a184));list.add(Arrays.asList(a185));list.add(Arrays.asList(a186));list.add(Arrays.asList(a187));list.add(Arrays.asList(a188));list.add(Arrays.asList(a189));list.add(Arrays.asList(a190));list.add(Arrays.asList(a191));list.add(Arrays.asList(a192));list.add(Arrays.asList(a193));list.add(Arrays.asList(a194));list.add(Arrays.asList(a195));list.add(Arrays.asList(a196));list.add(Arrays.asList(a197));list.add(Arrays.asList(a198));list.add(Arrays.asList(a199));list.add(Arrays.asList(a200));list.add(Arrays.asList(a201));list.add(Arrays.asList(a202));list.add(Arrays.asList(a203));list.add(Arrays.asList(a204));list.add(Arrays.asList(a205));list.add(Arrays.asList(a206));list.add(Arrays.asList(a207));list.add(Arrays.asList(a208));list.add(Arrays.asList(a209));list.add(Arrays.asList(a210));list.add(Arrays.asList(a211));list.add(Arrays.asList(a212));list.add(Arrays.asList(a213));list.add(Arrays.asList(a214));list.add(Arrays.asList(a215));list.add(Arrays.asList(a216));list.add(Arrays.asList(a217));list.add(Arrays.asList(a218));list.add(Arrays.asList(a219));list.add(Arrays.asList(a220));list.add(Arrays.asList(a221));list.add(Arrays.asList(a222));list.add(Arrays.asList(a223));list.add(Arrays.asList(a224));list.add(Arrays.asList(a225));list.add(Arrays.asList(a226));list.add(Arrays.asList(a227));list.add(Arrays.asList(a228));list.add(Arrays.asList(a229));list.add(Arrays.asList(a230));list.add(Arrays.asList(a231));list.add(Arrays.asList(a232));list.add(Arrays.asList(a233));list.add(Arrays.asList(a234));list.add(Arrays.asList(a235));list.add(Arrays.asList(a236));list.add(Arrays.asList(a237));list.add(Arrays.asList(a238));list.add(Arrays.asList(a239));list.add(Arrays.asList(a240));list.add(Arrays.asList(a241));list.add(Arrays.asList(a242));list.add(Arrays.asList(a243));list.add(Arrays.asList(a244));list.add(Arrays.asList(a245));list.add(Arrays.asList(a246));list.add(Arrays.asList(a247));list.add(Arrays.asList(a248));list.add(Arrays.asList(a249));list.add(Arrays.asList(a250));list.add(Arrays.asList(a251));list.add(Arrays.asList(a252));list.add(Arrays.asList(a253));list.add(Arrays.asList(a254));list.add(Arrays.asList(a255));list.add(Arrays.asList(a256));list.add(Arrays.asList(a257));list.add(Arrays.asList(a258));list.add(Arrays.asList(a259));list.add(Arrays.asList(a260));list.add(Arrays.asList(a261));list.add(Arrays.asList(a262));list.add(Arrays.asList(a263));list.add(Arrays.asList(a264));list.add(Arrays.asList(a265));list.add(Arrays.asList(a266));list.add(Arrays.asList(a267));list.add(Arrays.asList(a268));list.add(Arrays.asList(a269));list.add(Arrays.asList(a270));list.add(Arrays.asList(a271));list.add(Arrays.asList(a272));list.add(Arrays.asList(a273));list.add(Arrays.asList(a274));list.add(Arrays.asList(a275));list.add(Arrays.asList(a276));list.add(Arrays.asList(a277));list.add(Arrays.asList(a278));list.add(Arrays.asList(a279));list.add(Arrays.asList(a280));list.add(Arrays.asList(a281));list.add(Arrays.asList(a282));list.add(Arrays.asList(a283));list.add(Arrays.asList(a284));list.add(Arrays.asList(a285));list.add(Arrays.asList(a286));list.add(Arrays.asList(a287));list.add(Arrays.asList(a288));list.add(Arrays.asList(a289));list.add(Arrays.asList(a290));list.add(Arrays.asList(a291));list.add(Arrays.asList(a292));list.add(Arrays.asList(a293));list.add(Arrays.asList(a294));list.add(Arrays.asList(a295));list.add(Arrays.asList(a296));list.add(Arrays.asList(a297));list.add(Arrays.asList(a298));list.add(Arrays.asList(a299));list.add(Arrays.asList(a300));list.add(Arrays.asList(a301));list.add(Arrays.asList(a302));list.add(Arrays.asList(a303));list.add(Arrays.asList(a304));list.add(Arrays.asList(a305));list.add(Arrays.asList(a306));list.add(Arrays.asList(a307));list.add(Arrays.asList(a308));list.add(Arrays.asList(a309));list.add(Arrays.asList(a310));list.add(Arrays.asList(a311));list.add(Arrays.asList(a312));list.add(Arrays.asList(a313));list.add(Arrays.asList(a314));list.add(Arrays.asList(a315));list.add(Arrays.asList(a316));list.add(Arrays.asList(a317));list.add(Arrays.asList(a318));list.add(Arrays.asList(a319));list.add(Arrays.asList(a320));list.add(Arrays.asList(a321));list.add(Arrays.asList(a322));list.add(Arrays.asList(a323));list.add(Arrays.asList(a324));list.add(Arrays.asList(a325));list.add(Arrays.asList(a326));list.add(Arrays.asList(a327));list.add(Arrays.asList(a328));list.add(Arrays.asList(a329));list.add(Arrays.asList(a330));list.add(Arrays.asList(a331));list.add(Arrays.asList(a332));list.add(Arrays.asList(a333));list.add(Arrays.asList(a334));list.add(Arrays.asList(a335));list.add(Arrays.asList(a336));list.add(Arrays.asList(a337));list.add(Arrays.asList(a338));list.add(Arrays.asList(a339));list.add(Arrays.asList(a340));list.add(Arrays.asList(a341));list.add(Arrays.asList(a342));list.add(Arrays.asList(a343));list.add(Arrays.asList(a344));list.add(Arrays.asList(a345));list.add(Arrays.asList(a346));list.add(Arrays.asList(a347));list.add(Arrays.asList(a348));list.add(Arrays.asList(a349));list.add(Arrays.asList(a350));list.add(Arrays.asList(a351));list.add(Arrays.asList(a352));list.add(Arrays.asList(a353));list.add(Arrays.asList(a354));list.add(Arrays.asList(a355));list.add(Arrays.asList(a356));list.add(Arrays.asList(a357));list.add(Arrays.asList(a358));list.add(Arrays.asList(a359));list.add(Arrays.asList(a360));list.add(Arrays.asList(a361));list.add(Arrays.asList(a362));list.add(Arrays.asList(a363));list.add(Arrays.asList(a364));list.add(Arrays.asList(a365));list.add(Arrays.asList(a366));list.add(Arrays.asList(a367));list.add(Arrays.asList(a368));list.add(Arrays.asList(a369));list.add(Arrays.asList(a370));list.add(Arrays.asList(a371));list.add(Arrays.asList(a372));list.add(Arrays.asList(a373));list.add(Arrays.asList(a374));list.add(Arrays.asList(a375));list.add(Arrays.asList(a376));list.add(Arrays.asList(a377));list.add(Arrays.asList(a378));list.add(Arrays.asList(a379));list.add(Arrays.asList(a380));list.add(Arrays.asList(a381));list.add(Arrays.asList(a382));list.add(Arrays.asList(a383));list.add(Arrays.asList(a384));list.add(Arrays.asList(a385));list.add(Arrays.asList(a386));list.add(Arrays.asList(a387));list.add(Arrays.asList(a388));list.add(Arrays.asList(a389));list.add(Arrays.asList(a390));list.add(Arrays.asList(a391));list.add(Arrays.asList(a392));list.add(Arrays.asList(a393));list.add(Arrays.asList(a394));list.add(Arrays.asList(a395));list.add(Arrays.asList(a396));list.add(Arrays.asList(a397));list.add(Arrays.asList(a398));list.add(Arrays.asList(a399));list.add(Arrays.asList(a400));list.add(Arrays.asList(a401));list.add(Arrays.asList(a402));list.add(Arrays.asList(a403));list.add(Arrays.asList(a404));list.add(Arrays.asList(a405));list.add(Arrays.asList(a406));list.add(Arrays.asList(a407));list.add(Arrays.asList(a408));list.add(Arrays.asList(a409));list.add(Arrays.asList(a410));list.add(Arrays.asList(a411));list.add(Arrays.asList(a412));list.add(Arrays.asList(a413));list.add(Arrays.asList(a414));list.add(Arrays.asList(a415));list.add(Arrays.asList(a416));list.add(Arrays.asList(a417));list.add(Arrays.asList(a418));list.add(Arrays.asList(a419));list.add(Arrays.asList(a420));list.add(Arrays.asList(a421));list.add(Arrays.asList(a422));list.add(Arrays.asList(a423));list.add(Arrays.asList(a424));list.add(Arrays.asList(a425));list.add(Arrays.asList(a426));list.add(Arrays.asList(a427));list.add(Arrays.asList(a428));list.add(Arrays.asList(a429));list.add(Arrays.asList(a430));list.add(Arrays.asList(a431));list.add(Arrays.asList(a432));list.add(Arrays.asList(a433));list.add(Arrays.asList(a434));list.add(Arrays.asList(a435));list.add(Arrays.asList(a436));list.add(Arrays.asList(a437));list.add(Arrays.asList(a438));list.add(Arrays.asList(a439));list.add(Arrays.asList(a440));list.add(Arrays.asList(a441));list.add(Arrays.asList(a442));list.add(Arrays.asList(a443));list.add(Arrays.asList(a444));list.add(Arrays.asList(a445));list.add(Arrays.asList(a446));list.add(Arrays.asList(a447));list.add(Arrays.asList(a448));list.add(Arrays.asList(a449));list.add(Arrays.asList(a450));list.add(Arrays.asList(a451));list.add(Arrays.asList(a452));list.add(Arrays.asList(a453));list.add(Arrays.asList(a454));list.add(Arrays.asList(a455));list.add(Arrays.asList(a456));list.add(Arrays.asList(a457));list.add(Arrays.asList(a458));list.add(Arrays.asList(a459));list.add(Arrays.asList(a460));list.add(Arrays.asList(a461));list.add(Arrays.asList(a462));list.add(Arrays.asList(a463));list.add(Arrays.asList(a464));list.add(Arrays.asList(a465));list.add(Arrays.asList(a466));list.add(Arrays.asList(a467));list.add(Arrays.asList(a468));list.add(Arrays.asList(a469));list.add(Arrays.asList(a470));list.add(Arrays.asList(a471));list.add(Arrays.asList(a472));list.add(Arrays.asList(a473));list.add(Arrays.asList(a474));list.add(Arrays.asList(a475));list.add(Arrays.asList(a476));list.add(Arrays.asList(a477));list.add(Arrays.asList(a478));list.add(Arrays.asList(a479));list.add(Arrays.asList(a480));list.add(Arrays.asList(a481));list.add(Arrays.asList(a482));list.add(Arrays.asList(a483));list.add(Arrays.asList(a484));list.add(Arrays.asList(a485));list.add(Arrays.asList(a486));list.add(Arrays.asList(a487));list.add(Arrays.asList(a488));list.add(Arrays.asList(a489));list.add(Arrays.asList(a490));list.add(Arrays.asList(a491));list.add(Arrays.asList(a492));list.add(Arrays.asList(a493));list.add(Arrays.asList(a494));list.add(Arrays.asList(a495));list.add(Arrays.asList(a496));list.add(Arrays.asList(a497));list.add(Arrays.asList(a498));list.add(Arrays.asList(a499));list.add(Arrays.asList(a500));
		freqQuery(list);
		}

}
