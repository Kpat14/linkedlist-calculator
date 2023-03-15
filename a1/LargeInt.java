package a1;

import a1.SpecializedList.SlistNode;

public class LargeInt implements LargeIntInterface {
	
	
	public String replaceNeg(String r) {
		r = r.replace("-","");
		return r;
	}
	
	
	public int compare(SpecializedList a, SpecializedList b) {
		a.resetBackward();
		b.resetBackward();
		int g = 2;
		
		while(a.currentb != null) {
			if(a.currentb.data > b.currentb.data) {
				g = 0;
				return g;
			}
			if(a.currentb.data < b.currentb.data) {
				g = 1;
				return g;
			}
			if(a.currentb.data == b.currentb.data) {
				a.currentb = a.currentb.prev;
				b.currentb = b.currentb.prev;
			}
		}
		if(a.currentb == null) {
			g = 2;
			return g;
		}
		
		return g;
	}
	
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		LargeInt n = new LargeInt("23");
 		n.setNegative();
 		LargeInt m = new LargeInt("23");
 		LargeIntInterface d = m.add(n);

 		
  		 

	}
	private String s;
	private String sec;
	private SpecializedList first;
	private SpecializedList second;
	private byte[] bytes;
	private byte[] secbytes;
 	public LargeInt(String s) {
		
		boolean isN = (s.charAt(0) ==  '-');
 		
 		if(isN) {
 	 		bytes = new byte[s.length()-1];
 		}else {
 	 		bytes = new byte[s.length()];
 		}
		int l = 0;
		if(isN) {
			if(s.charAt(0) ==  '-') {
				String z = "-";
				z += s.charAt(1);
				bytes[0] = Byte.parseByte(z);
				l++;
			} 
			while(l < s.length()-1) {
				bytes[l] = Byte.parseByte(s.substring(l+1, l+2), 16);
				l++;
			}
		}else {
			if(s.charAt(0) ==  '-') {
				String z = "-";
				z += s.charAt(1);
				bytes[0] = Byte.parseByte(z);
				l++;
			} 
			while(l < s.length()) {
				bytes[l] = Byte.parseByte(s.substring(l+0, l+1), 16);
				l++;
			}
		}
		
		 
		this.s = s; 
		
 		first = new SpecializedList();
 		for(int g = 0; g < bytes.length;g++) {
 	 		first.insertFront(bytes[g]);
  		}
  		
 		first.display();
 		 
	}
	
	@Override
	public LargeInt add(LargeInt a) {
		// TODO Auto-generated method stub
		this.sec = a.toString();	
	 
		if(a.setNegative()) {
			
		}
		SpecializedList sum = new SpecializedList();
 		
		
		boolean isN = (sec.charAt(0) ==  '-');
 
 		if(isN) {
 	 		secbytes = new byte[sec.length()-1];
 		}else {
 	 		secbytes = new byte[sec.length()];
 		}
		int l = 0;
		if(isN) {
			if(sec.charAt(0) ==  '-') {
				String z = "-";
				z += sec.charAt(1);
				secbytes[0] = Byte.parseByte(z);
				l++;
			} 
			while(l < sec.length()-1) {
				secbytes[l] = Byte.parseByte(sec.substring(l+1, l+2), 16);
				l++;
			}
		}else {
			while(l < sec.length()) {
				secbytes[l] = Byte.parseByte(sec.substring(l+0, l+1), 16);
				l++;
			}
		}
		
 		
		
		second = new SpecializedList();
		int i = 0;
		while(i < secbytes.length) {
	 		second.insertFront(secbytes[i]);
			i++;
		}
		
		first.resetBackward();
		second.resetBackward();
		
		if(first.currentb.data == 0 && first.lengthIs() > 1) {
 			first.resetBackward();
 			while((int) first.currentb.data == 0) {
 				first.tail = first.tail.prev;
 	 			first.tail.next = null;
 	 			first.currentb = first.tail;
 			}
	    }
		if(second.currentb.data == 0 && second.lengthIs() > 1) {
 			second.resetBackward();
 			while((int) second.currentb.data == 0) {
 				second.tail = second.tail.prev;
 	 			second.tail.next = null;
 	 			second.currentb = second.tail;
 			}
	    }
		
		String ns = replaceNeg(s);
	   	String nsec = replaceNeg(sec);
	   		 
	 		byte [] nbytes = new byte[ns.length()];
	 		byte [] nsecbytes = new byte[nsec.length()];

	   		int i1 = 0;
	   		while(i1 < ns.length()) {
			nbytes[i1] = Byte.parseByte(ns.substring(i1+0, i1+1), 16);
	   			i1++;
	   		}
	   		int i2 = 0;
	   		while(i2 < nsec.length()) {
				nsecbytes[i2] = Byte.parseByte(nsec.substring(i2+0, i2+1), 16);
	 	   		i2++;
	 	   	}
	   		
	   		SpecializedList newfirst = new SpecializedList();
	   		SpecializedList newsecond = new SpecializedList();
	   		
 	   	for(int g = 0; g < bytes.length;g++) {
 	 		newfirst.insertFront(nbytes[g]);
  		}
 	    for(int g = 0; g < secbytes.length;g++) {
 	 		newsecond.insertFront(nsecbytes[g]);
  		}
 	    
 	   newfirst.resetBackward();
 	   newsecond.resetBackward();
 	   if(newfirst.currentb.data == 0 && newfirst.lengthIs() > 1) {
			newfirst.resetBackward();
			while((int) newfirst.currentb.data == 0) {
				newfirst.tail = newfirst.tail.prev;
	 			newfirst.tail.next = null;
	 			newfirst.currentb = newfirst.tail;
			}
	    }
 	   if(newsecond.currentb.data == 0 && newsecond.lengthIs() > 1) {
			newsecond.resetBackward();
			while((int) newsecond.currentb.data == 0) {
				newsecond.tail = newsecond.tail.prev;
	 			newsecond.tail.next = null;
	 			newsecond.currentb = newsecond.tail;
			}
	    }
 	   newsecond.resetBackward();
 	   newfirst.resetBackward();
	   		
 	    System.out.println();
	 	 System.out.println("first");
	  	 first.display();
	  	 System.out.println();
	 	 System.out.println("sec");
	  	 second.display();
	  	 System.out.println();
		
  	    System.out.println();
 	    System.out.println("newfirst");
  	    newfirst.display();
  	    System.out.println();
 	    System.out.println("newsec");
  	    newsecond.display();
  	    System.out.println();
		 
  		 
		first.resetBackward();
		second.resetBackward();
		
		
		if((int) first.currentb.data == 0 && (int)second.currentb.data == 0){
			if (compare(newfirst, newsecond) == 2) {
	 	    	sum.insertEnd((byte) 0);
			}
			
		}else if((int) first.currentb.data >= 0 && (int)second.currentb.data >= 0) {
			
	 	    if(bytes.length > secbytes.length) {
	 	    	int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 
	 				
	 				add = x + y + carry;
	 				carry = add/10;
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}

				
			}else if (bytes.length < secbytes.length){
				int add = 0;
	 			int carry = 0;
	 			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 
	 				
	 				add = x + y + carry;
	 				carry = add/10;
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	 			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
				
			}else if (bytes.length == secbytes.length){
				int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 
	 				
	 				add = x + y + carry;
	 				carry = add/10;
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
				
			}
			
		}else if((int) first.currentb.data >= 0 && (int)second.currentb.data <= 0){
			if(bytes.length > secbytes.length) {
	 			int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				if(newfirst.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0)  {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
				
			}else if (bytes.length < secbytes.length){
				int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					y = newfirst.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					x = newsecond.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				
	 				if(newsecond.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
	 			 
			}else if (bytes.length == secbytes.length){
				if(compare(newfirst, newsecond) == 0) {
					
					 

		 			int borrow = 0;
		 			int subTract = 0;
		  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
		 				int x = 0;
		 				int y = 0;
		 				if(newfirst.currentf != null) {
		 					x = newfirst.currentf.data;
		 				}else {
		 					x = 0;
		 				}
		 				if(newsecond.currentf != null) {
		 					y = newsecond.currentf.data;
		 				}else {
		 					y = 0;
		 				}
		 				
		 				if(newfirst.currentf != null || borrow != 0) {
		 					subTract = x - y - borrow;
		 				} 
		 				
		 
		 				
		 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
		 					if(subTract < 0) {
		 	 					subTract += 10;
		 	 					borrow = 1;
		 	 				}else {
		 	 					borrow = 0;
		 	 				}
		 				} 
				 	   
		
		 		 
		 				 	
		 				
		 				
		 				sum.insertEnd((byte) ((byte)subTract%10));
		 				
		 				
		 				
		 				if(newfirst.currentf != null) {
		 					newfirst.currentf = newfirst.currentf.next;
		 				}
		 				if(newsecond.currentf != null) {
		 					newsecond.currentf = newsecond.currentf.next;
		 				}
		 			}
		  		
		  			if(first.currentb.data != 0 && second.currentb.data != 0) {
			 			sum.resetBackward();
			 			while((int) sum.currentb.data == 0) {
			 				sum.tail = sum.tail.prev;
			 	 			sum.tail.next = null;
			 	 			sum.currentb = sum.tail;
			 			}
		 	    	}
		 			
		 			 
		 	    }
		 	    
		 	    if (compare(newfirst, newsecond) == 1) {
		 	    	
 
			 			int borrow = 0;
			 			int subTract = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					y = newfirst.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					x = newsecond.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				
			 				if(newfirst.currentf != null || borrow != 0) {
			 					subTract = x - y - borrow;
			 				} 
			 				
			 
			 				
			 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 					if(subTract < 0) {
			 	 					subTract += 10;
			 	 					borrow = 1;
			 	 				}else {
			 	 					borrow = 0;
			 	 				}
			 				} 
					 	   
			
			 		 
			 				 	
			 				
			 				
			 				sum.insertEnd((byte) ((byte)subTract%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 			
			 			if((int) sum.currentb.data > 0) {
			 				String c = "-";
			 				int ww = sum.currentb.data;
			 				c = c + ww;
			 				int join = Integer.valueOf(c);
			 				sum.currentb.data =  (byte) join;
			 			}
			 			
			 	
			 	    }
		 	    
		 	    
			 	    if (compare(newfirst, newsecond) == 2) {
			 	    	sum.insertEnd((byte) 0);
			 	    }
				
			}
			
		}else if((int) first.currentb.data <= 0 && (int)second.currentb.data >= 0){
			if(bytes.length > secbytes.length) {
				
				System.out.println("check");
				
				int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 			 
	 				
	 				
	 				if(newfirst.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
				
			}else if (bytes.length < secbytes.length){
				int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					y = newfirst.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					x = newsecond.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				
	 				if(newsecond.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			
			}else if (bytes.length == secbytes.length){
				
				if(compare(newfirst, newsecond) == 0) {
					
 

		 			int borrow = 0;
		 			int subTract = 0;
		  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
		 				int x = 0;
		 				int y = 0;
		 				if(newfirst.currentf != null) {
		 					x = newfirst.currentf.data;
		 				}else {
		 					x = 0;
		 				}
		 				if(newsecond.currentf != null) {
		 					y = newsecond.currentf.data;
		 				}else {
		 					y = 0;
		 				}
		 				
		 				if(newfirst.currentf != null || borrow != 0) {
		 					subTract = x - y - borrow;
		 				} 
		 				
		 
		 				
		 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
		 					if(subTract < 0) {
		 	 					subTract += 10;
		 	 					borrow = 1;
		 	 				}else {
		 	 					borrow = 0;
		 	 				}
		 				} 
				 	   
		
		 		 
		 				 	
		 				
		 				
		 				sum.insertEnd((byte) ((byte)subTract%10));
		 				
		 				
		 				
		 				if(newfirst.currentf != null) {
		 					newfirst.currentf = newfirst.currentf.next;
		 				}
		 				if(newsecond.currentf != null) {
		 					newsecond.currentf = newsecond.currentf.next;
		 				}
		 			}
		  		
		  			if(first.currentb.data != 0 && second.currentb.data != 0) {
			 			sum.resetBackward();
			 			while((int) sum.currentb.data == 0) {
			 				sum.tail = sum.tail.prev;
			 	 			sum.tail.next = null;
			 	 			sum.currentb = sum.tail;
			 			}
		 	    	}
		 			
		 			if((int) sum.currentb.data > 0) {
		 				String c = "-";
		 				int ww = sum.currentb.data;
		 				c = c + ww;
		 				int join = Integer.valueOf(c);
		 				sum.currentb.data =  (byte) join;
		 			}
		 	    	
		 	    }
		 	    
		 	    if (compare(newfirst, newsecond) == 1) {
		 	    	
		 	    		System.out.println("||||||||");

			 			int borrow = 0;
			 			int subTract = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					y = newfirst.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					x = newsecond.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				
			 				if(newsecond.currentf != null || borrow != 0) {
			 					subTract = x - y - borrow;
			 				} 
			 				
			 
			 				
			 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 					if(subTract < 0) {
			 	 					subTract += 10;
			 	 					borrow = 1;
			 	 				}else {
			 	 					borrow = 0;
			 	 				}
			 				} 
					 	   
			
			 		 
			 				 	
			 				
			 				
			 				sum.insertEnd((byte) ((byte)subTract%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 			
			 	
			 	    }
		 	    
		 	    
			 	    if (compare(newfirst, newsecond) == 2) {
			 	    	sum.insertEnd((byte) 0);
			 	    }
				
			}
			
		}else if((int) first.currentb.data <= 0 && (int)second.currentb.data <= 0){
			if(bytes.length > secbytes.length) {
				int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 
	 				
	 				add = x + y + carry;
	 				carry = add/10;
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
				
			}else if (bytes.length < secbytes.length){
				int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 
	 				
	 				add = x + y + carry;
	 				carry = add/10;
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
				
			}else if (bytes.length == secbytes.length){
				int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 
	 				
	 				add = x + y + carry;
	 				carry = add/10;
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
				
			}
			
		}
 		
		

		String x = "";
		while(sum.currentb != null) {
			x += sum.currentb.data;
			sum.currentb = sum.currentb.prev;
		}
		
		int index = 0;
		while (index < x.length() && x.length() > 1) {
			String n = x.substring(index, index + 1);
			if(n.equals("0")) {
				x = x.substring(index+1);
			}
			else {
				break;
			}
		}
		
   		System.out.println(x);
   		sum.display();
  		LargeInt w = new LargeInt(x);
	 	 
 		
		return w;
 	}
 

	 

	@Override
	public LargeInt subtract(LargeInt me2) {
		this.sec = me2.toString();	
		 

		SpecializedList sum = new SpecializedList();
 		
		
		boolean isN = (sec.charAt(0) ==  '-');
 
 		if(isN) {
 	 		secbytes = new byte[sec.length()-1];
 		}else {
 	 		secbytes = new byte[sec.length()];
 		}
		int l = 0;
		if(isN) {
			if(sec.charAt(0) ==  '-') {
				String z = "-";
				z += sec.charAt(1);
				secbytes[0] = Byte.parseByte(z);
				l++;
			} 
			while(l < sec.length()-1) {
				secbytes[l] = Byte.parseByte(sec.substring(l+1, l+2), 16);
				l++;
			}
		}else {
			while(l < sec.length()) {
				secbytes[l] = Byte.parseByte(sec.substring(l+0, l+1), 16);
				l++;
			}
		}
		
		
		
		
		second = new SpecializedList();
		int i = 0;
		while(i < secbytes.length) {
	 		second.insertFront(secbytes[i]);
			i++;
		}
		
		first.resetBackward();
		second.resetBackward();
		
		if(first.currentb.data == 0 && first.lengthIs() > 1) {
 			first.resetBackward();
 			while((int) first.currentb.data == 0) {
 				first.tail = first.tail.prev;
 	 			first.tail.next = null;
 	 			first.currentb = first.tail;
 			}
	    }
		if(second.currentb.data == 0 && second.lengthIs() > 1) {
 			second.resetBackward();
 			while((int) second.currentb.data == 0) {
 				second.tail = second.tail.prev;
 	 			second.tail.next = null;
 	 			second.currentb = second.tail;
 			}
	    }
		
 	 	 
		 
			
		
		String ns = replaceNeg(s);
	   	String nsec = replaceNeg(sec);
	   		 
	 		byte [] nbytes = new byte[ns.length()];
	 		byte [] nsecbytes = new byte[nsec.length()];

	   		int i1 = 0;
	   		while(i1 < ns.length()) {
			nbytes[i1] = Byte.parseByte(ns.substring(i1+0, i1+1), 16);
	   			i1++;
	   		}
	   		int i2 = 0;
	   		while(i2 < nsec.length()) {
				nsecbytes[i2] = Byte.parseByte(nsec.substring(i2+0, i2+1), 16);
	 	   		i2++;
	 	   	}
	   		
	   		SpecializedList newfirst = new SpecializedList();
	   		SpecializedList newsecond = new SpecializedList();
	   		
 	   	for(int g = 0; g < bytes.length;g++) {
 	 		newfirst.insertFront(nbytes[g]);
  		}
 	    for(int g = 0; g < secbytes.length;g++) {
 	 		newsecond.insertFront(nsecbytes[g]);
  		}
 	    
 	   newfirst.resetBackward();
 	   newsecond.resetBackward();
 	   if(newfirst.currentb.data == 0 && newfirst.lengthIs() > 1) {
			newfirst.resetBackward();
			while((int) newfirst.currentb.data == 0) {
				newfirst.tail = newfirst.tail.prev;
	 			newfirst.tail.next = null;
	 			newfirst.currentb = newfirst.tail;
			}
	    }
 	   if(newsecond.currentb.data == 0 && newsecond.lengthIs() > 1) {
			newsecond.resetBackward();
			while((int) newsecond.currentb.data == 0) {
				newsecond.tail = newsecond.tail.prev;
	 			newsecond.tail.next = null;
	 			newsecond.currentb = newsecond.tail;
			}
	    }
 	   newsecond.resetBackward();
 	   newfirst.resetBackward();
 	    
 	   System.out.println();
	 	 System.out.println("first");
	  	 first.display();
	  	 System.out.println();
	 	 System.out.println("sec");
	  	 second.display();
	  	 System.out.println();
		
	    System.out.println();
	    System.out.println("newfirst");
	    newfirst.display();
	    System.out.println();
	    System.out.println("newsec");
	    newsecond.display();
	    System.out.println();
 		
		
		first.resetBackward();
		second.resetBackward();
		
		if((int) first.currentb.data == 0 && (int)second.currentb.data == 0){
			if (compare(newfirst, newsecond) == 2) {
	 	    	sum.insertEnd((byte) 0);
			}
			
		}else if((int) first.currentb.data < 0 && (int)second.currentb.data < 0) {
			
			if(bytes.length > secbytes.length) {
				
	
		 	    
	 			int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				if(newfirst.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null  || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0 ) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
	 			
			}else if(secbytes.length > bytes.length) {
				
	
	
		 	    
	 			int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					y = newfirst.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					x = newsecond.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				
	 				if(newsecond.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			 
				
			}else if((secbytes.length == bytes.length)) {
				
				
		 	    if(compare(newfirst, newsecond) == 0) {

		 			int borrow = 0;
		 			int subTract = 0;
		  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
		 				int x = 0;
		 				int y = 0;
		 				if(newfirst.currentf != null) {
		 					x = newfirst.currentf.data;
		 				}else {
		 					x = 0;
		 				}
		 				if(newsecond.currentf != null) {
		 					y = newsecond.currentf.data;
		 				}else {
		 					y = 0;
		 				}
		 				
		 				if(newfirst.currentf != null || borrow != 0) {
		 					subTract = x - y - borrow;
		 				} 
		 				
		 
		 				
		 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
		 					if(subTract < 0) {
		 	 					subTract += 10;
		 	 					borrow = 1;
		 	 				}else {
		 	 					borrow = 0;
		 	 				}
		 				} 
				 	   
		
		 		 
		 				 	
		 				
		 				
		 				sum.insertEnd((byte) ((byte)subTract%10));
		 				
		 				
		 				
		 				if(newfirst.currentf != null) {
		 					newfirst.currentf = newfirst.currentf.next;
		 				}
		 				if(newsecond.currentf != null) {
		 					newsecond.currentf = newsecond.currentf.next;
		 				}
		 			}
		  		
		  			if(first.currentb.data != 0 && second.currentb.data != 0) {
			 			sum.resetBackward();
			 			while((int) sum.currentb.data == 0) {
			 				sum.tail = sum.tail.prev;
			 	 			sum.tail.next = null;
			 	 			sum.currentb = sum.tail;
			 			}
		 	    	}
		 			
		 			if((int) sum.currentb.data > 0) {
		 				String c = "-";
		 				int ww = sum.currentb.data;
		 				c = c + ww;
		 				int join = Integer.valueOf(c);
		 				sum.currentb.data =  (byte) join;
		 			}
		 	    	
		 	    }
		 	    
		 	    if (compare(newfirst, newsecond) == 1) {
		 	    	


			 			int borrow = 0;
			 			int subTract = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					y = newfirst.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					x = newsecond.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				
			 				if(newsecond.currentf != null || borrow != 0) {
			 					subTract = x - y - borrow;
			 				} 
			 				
			 
			 				
			 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 					if(subTract < 0) {
			 	 					subTract += 10;
			 	 					borrow = 1;
			 	 				}else {
			 	 					borrow = 0;
			 	 				}
			 				} 
					 	   
			
			 		 
			 				 	
			 				
			 				
			 				sum.insertEnd((byte) ((byte)subTract%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 			
			 	    }
		 	    
		 	    
			 	    if (compare(newfirst, newsecond) == 2) {
			 	    	sum.insertEnd((byte) 0);
			 	    }
			 	    	
	
		 	    
		 	    
	 			
			}
	 	    
			
			
			
			
		}else if((int) first.currentb.data <= 0 && (int)second.currentb.data >= 0){
			if(bytes.length > secbytes.length) {
				
	
		 	    
	 			int carry = 0;
	 			int add = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				 
	 				
	 
	 				
	 				add = carry + x + y;
					carry = add/10;
 			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
	 			
			}else if(secbytes.length > bytes.length) {
				
	
	
		 	    
	 			int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					y = newfirst.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					x = newsecond.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				
	 				add = carry + x + y;
					carry = add/10;
					sum.insertEnd((byte) ((byte) add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
				
				
			}else if((secbytes.length == bytes.length)) {
				
			
		 	    
		 	    if(compare(newfirst, newsecond) == 0) {

		 			int add = 0;
		 			int carry = 0;
		  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
		 				int x = 0;
		 				int y = 0;
		 				if(newfirst.currentf != null) {
		 					x = newfirst.currentf.data;
		 				}else {
		 					x = 0;
		 				}
		 				if(newsecond.currentf != null) {
		 					y = newsecond.currentf.data;
		 				}else {
		 					y = 0;
		 				}
		 				
		 				add = carry + x + y;
						carry = add/10;
	 			 	   
		
		 		 
		 				 	
		 				
		 				
		 				sum.insertEnd((byte) ((byte)add%10));
		 				
		 				
		 				
		 				if(newfirst.currentf != null) {
		 					newfirst.currentf = newfirst.currentf.next;
		 				}
		 				if(newsecond.currentf != null) {
		 					newsecond.currentf = newsecond.currentf.next;
		 				}
		 			}
		  		
		  			if(first.currentb.data != 0 && second.currentb.data != 0) {
			 			sum.resetBackward();
			 			while((int) sum.currentb.data == 0) {
			 				sum.tail = sum.tail.prev;
			 	 			sum.tail.next = null;
			 	 			sum.currentb = sum.tail;
			 			}
		 	    	}
		  			
		 			if((int) sum.currentb.data > 0) {
		 				String c = "-";
		 				int ww = sum.currentb.data;
		 				c = c + ww;
		 				int join = Integer.valueOf(c);
		 				sum.currentb.data =  (byte) join;
		 			}
		 	    	
		 	    }
		 	    
		 	    if (compare(newfirst, newsecond) == 1) {
		 	    	


			 			int add = 0;
			 			int carry = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0)  {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					y = newfirst.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					x = newsecond.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				
			 				 
					 	   
			
			 		 
			 				 	
			 				
			 				
			 				add = carry + x + y;
							carry = add/10;
		 			 	   
			
			 		 
			 				 	
			 				
			 				
			 				sum.insertEnd((byte) ((byte)add%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 			
			 			if((int) sum.currentb.data > 0) {
			 				String c = "-";
			 				int ww = sum.currentb.data;
			 				c = c + ww;
			 				int join = Integer.valueOf(c);
			 				sum.currentb.data =  (byte) join;
			 			}
			 	    }
		 	    
		 	    
			 	    if (compare(newfirst, newsecond) == 2) {
			 	    	int add = 0;
			 			int carry = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					y = newfirst.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					x = newsecond.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				
			 				 
					 	   
			
			 		 
			 				 	
			 				
			 				
			 				add = carry + x + y;
							carry = add/10;
		 			 	   
			
			 		 
			 				 	
			 				
			 				
			 				sum.insertEnd((byte) ((byte)add%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 			
			 			if((int) sum.currentb.data > 0) {
			 				String c = "-";
			 				int ww = sum.currentb.data;
			 				c = c + ww;
			 				int join = Integer.valueOf(c);
			 				sum.currentb.data =  (byte) join;
			 			}
			 	    }
			 	    	
	
		 	    
		 	    
	 			
			}
			
			
			
			
		}else if((int) first.currentb.data >= 0 && (int)second.currentb.data <= 0){
			if(bytes.length > secbytes.length) {
				 
	
	
		 	    
	 			int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				add = carry + x + y;
					carry = add/10;
					sum.insertEnd((byte) ((byte) add%10));
	 				
	 
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			
			}else if(secbytes.length > bytes.length) {
				 
	
		 	    
	 			int add = 0;
	 			int carry = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0){
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					y = newfirst.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					x = newsecond.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				
	 				add = carry + x + y;
					carry = add/10;
					sum.insertEnd((byte) ((byte) add%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			 
				
			}else if((secbytes.length == bytes.length)) {
					
					 
			 	    
			 	    if(compare(newfirst, newsecond) == 0) {

			 			int add= 0;
			 			int carry = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					x = newfirst.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					y = newsecond.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				
		
			 				
			 				add = carry + x + y;
							carry = add/10;
							sum.insertEnd((byte) ((byte) add%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 				
			 				
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 	    	
			 			 
			 	    }
			 	    
			 	    if (compare(newfirst, newsecond) == 1) {
			 	    	


				 			int carry = 0;
				 			int add = 0;
				  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
				 				int x = 0;
				 				int y = 0;
				 				if(newfirst.currentf != null) {
				 					y = newfirst.currentf.data;
				 				}else {
				 					y = 0;
				 				}
				 				if(newsecond.currentf != null) {
				 					x = newsecond.currentf.data;
				 				}else {
				 					x = 0;
				 				}
				 				
				 				add = carry + x + y;
								carry = add/10;
								sum.insertEnd((byte) ((byte) add%10));
				 				
				 				
				 				
				 				if(newfirst.currentf != null) {
				 					newfirst.currentf = newfirst.currentf.next;
				 				}
				 				if(newsecond.currentf != null) {
				 					newsecond.currentf = newsecond.currentf.next;
				 				}
				 			}
				  		
				  			if(first.currentb.data != 0 && second.currentb.data != 0) {
					 			sum.resetBackward();
					 			while((int) sum.currentb.data == 0) {
					 				sum.tail = sum.tail.prev;
					 	 			sum.tail.next = null;
					 	 			sum.currentb = sum.tail;
					 			}
				 	    	}
				 			
				 			
				 	    }
			 	    
			 	    
				 	    if (compare(newfirst, newsecond) == 2) {
				 	    	int add = 0;
				 			int carry = 0;
				  			while(newfirst.currentf != null || newsecond.currentf != null || carry != 0) {
				 				int x = 0;
				 				int y = 0;
				 				if(newfirst.currentf != null) {
				 					x = newfirst.currentf.data;
				 				}else {
				 					x = 0;
				 				}
				 				if(newsecond.currentf != null) {
				 					y = newsecond.currentf.data;
				 				}else {
				 					y = 0;
				 				}
				 				
				 				add = carry + x + y;
								carry = add/10;
			 			 	   
				
				 		 
				 				 	
				 				
				 				
				 				sum.insertEnd((byte) ((byte)add%10));
				 				
				 				
				 				
				 				if(newfirst.currentf != null) {
				 					newfirst.currentf = newfirst.currentf.next;
				 				}
				 				if(newsecond.currentf != null) {
				 					newsecond.currentf = newsecond.currentf.next;
				 				}
				 			}
				  		
				  			if(first.currentb.data != 0 && second.currentb.data != 0) {
					 			sum.resetBackward();
					 			while((int) sum.currentb.data == 0) {
					 				sum.tail = sum.tail.prev;
					 	 			sum.tail.next = null;
					 	 			sum.currentb = sum.tail;
					 			}
				 	    	}
				 			
				 	    }
				 	    	
				 	    
				}
			
		
			 
		}else if((int) first.currentb.data >= 0 && (int)second.currentb.data >= 0){
			if(first.lengthIs() > second.lengthIs()) {
				 
				System.out.print("hello");
		 	    
	 			int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					x = newfirst.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					y = newsecond.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				
	 				if(newfirst.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			 
	 			
			}else if(first.lengthIs() < second.lengthIs()) {
				 
	
	
		 	    
	 			int borrow = 0;
	 			int subTract = 0;
	  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 				int x = 0;
	 				int y = 0;
	 				if(newfirst.currentf != null) {
	 					y = newfirst.currentf.data;
	 				}else {
	 					y = 0;
	 				}
	 				if(newsecond.currentf != null) {
	 					x = newsecond.currentf.data;
	 				}else {
	 					x = 0;
	 				}
	 				
	 				if(newsecond.currentf != null || borrow != 0) {
	 					subTract = x - y - borrow;
	 				} 
	 				
	 
	 				
	 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
	 					if(subTract < 0) {
	 	 					subTract += 10;
	 	 					borrow = 1;
	 	 				}else {
	 	 					borrow = 0;
	 	 				}
	 				} 
			 	   
	
	 		 
	 				 	
	 				
	 				
	 				sum.insertEnd((byte) ((byte)subTract%10));
	 				
	 				
	 				
	 				if(newfirst.currentf != null) {
	 					newfirst.currentf = newfirst.currentf.next;
	 				}
	 				if(newsecond.currentf != null) {
	 					newsecond.currentf = newsecond.currentf.next;
	 				}
	 			}
	  		
	  			if(first.currentb.data != 0 && second.currentb.data != 0) {
		 			sum.resetBackward();
		 			while((int) sum.currentb.data == 0) {
		 				sum.tail = sum.tail.prev;
		 	 			sum.tail.next = null;
		 	 			sum.currentb = sum.tail;
		 			}
	 	    	}
	 			
	 			if((int) sum.currentb.data > 0) {
	 				String c = "-";
	 				int ww = sum.currentb.data;
	 				c = c + ww;
	 				int join = Integer.valueOf(c);
	 				sum.currentb.data =  (byte) join;
	 			}
				
				
			}else if(first.lengthIs() == second.lengthIs()) {
							 
		 	    if(compare(newfirst, newsecond) == 0) {

		 			int borrow = 0;
		 			int subTract = 0;
		  			while(newfirst.currentf != null || newsecond.currentf != null) {
		 				int x = 0;
		 				int y = 0;
		 				if(newfirst.currentf != null) {
		 					x = newfirst.currentf.data;
		 				}else {
		 					x = 0;
		 				}
		 				if(newsecond.currentf != null) {
		 					y = newsecond.currentf.data;
		 				}else {
		 					y = 0;
		 				}
		 				
		 				if(newfirst.currentf != null || subTract != 0) {
		 					subTract = x - y - borrow;
		 				} 
		 				
		 
		 				
		 				if(newfirst.currentf != null || newsecond.currentf != null || subTract != 0) {
		 					if(subTract < 0) {
		 	 					subTract += 10;
		 	 					borrow = 1;
		 	 				}else {
		 	 					borrow = 0;
		 	 				}
		 				} 
				 	   
		
		 		 
		 				 	
		 				
		 				
		 				sum.insertEnd((byte) ((byte)subTract%10));
		 				
		 				
		 				
		 				if(newfirst.currentf != null) {
		 					newfirst.currentf = newfirst.currentf.next;
		 				}
		 				if(newsecond.currentf != null) {
		 					newsecond.currentf = newsecond.currentf.next;
		 				}
		 			}
		  		
		  			if(first.currentb.data != 0 && second.currentb.data != 0) {
			 			sum.resetBackward();
			 			while((int) sum.currentb.data == 0) {
			 				sum.tail = sum.tail.prev;
			 	 			sum.tail.next = null;
			 	 			sum.currentb = sum.tail;
			 			}
		 	    	}
		 	    	
		 	    }
		 	    
		 	    if (compare(newfirst, newsecond) == 1) {
		 	    	
		 	    		System.out.print("hello");

			 			int borrow = 0;
			 			int subTract = 0;
			  			while(newfirst.currentf != null || newsecond.currentf != null || borrow != 0)  {
			 				int x = 0;
			 				int y = 0;
			 				if(newfirst.currentf != null) {
			 					y = newfirst.currentf.data;
			 				}else {
			 					y = 0;
			 				}
			 				if(newsecond.currentf != null) {
			 					x = newsecond.currentf.data;
			 				}else {
			 					x = 0;
			 				}
			 				
			 				if(newsecond.currentf != null || borrow != 0) {
			 					subTract = x - y - borrow;
			 				} 
			 				
			 
			 				
			 				if(newfirst.currentf != null || newsecond.currentf != null || borrow != 0) {
			 					if(subTract < 0) {
			 	 					subTract += 10;
			 	 					borrow = 1;
			 	 				}else {
			 	 					borrow = 0;
			 	 				}
			 				} 
					 	   
			
			 		 
			 				 	
			 				
			 				
			 				sum.insertEnd((byte) ((byte)subTract%10));
			 				
			 				
			 				
			 				if(newfirst.currentf != null) {
			 					newfirst.currentf = newfirst.currentf.next;
			 				}
			 				if(newsecond.currentf != null) {
			 					newsecond.currentf = newsecond.currentf.next;
			 				}
			 			}
			  		
			  			if(first.currentb.data != 0 && second.currentb.data != 0) {
				 			sum.resetBackward();
				 			while((int) sum.currentb.data == 0) {
				 				sum.tail = sum.tail.prev;
				 	 			sum.tail.next = null;
				 	 			sum.currentb = sum.tail;
				 			}
			 	    	}
			 			
			 			if((int) sum.currentb.data > 0) {
			 				String c = "-";
			 				int ww = sum.currentb.data;
			 				c = c + ww;
			 				int join = Integer.valueOf(c);
			 				sum.currentb.data =  (byte) join;
			 			} 
			 	    }
		 	    
		 	    
			 	    if (compare(newfirst, newsecond) == 2) {
			 	    	sum.insertEnd((byte) 0);
			 	    }
				
	 			
			}
			
			
		}
		
		
		
		
		// TODO Auto-generated method stub
		String x = "";
		while(sum.currentb != null) {
			x += sum.currentb.data;
			sum.currentb = sum.currentb.prev;
		}
		
		
		int index = 0;
		while (index < x.length() && x.length() > 1) {
			String n = x.substring(index, index + 1);
			if(n.equals("0")) {
				x = x.substring(index+1);
			}
			else {
				break;
			}
		}
		
		
		
   		System.out.println(x);
   		sum.display();
   		System.out.println();
   		System.out.println(x);
  		LargeInt w = new LargeInt(x);
	 	 
 		
		return w;
	}

	@Override
	public void setNegative() {
		// TODO Auto-generated method stub
		boolean isN = (s.charAt(0) ==  '-');
		 
 		if(isN) {
 	 		s = s.replace("-", "");
 		}else {
 	 		s = "-" + s;
 		}
		 
	 

	}
	
	@Override
	public String toString(){
		return this.s.replace("+","").replace(",", "");
		
	}
	

	

}
