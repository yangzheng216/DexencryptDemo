package com.example.dexencryptdemo.encrypt;

public class ByteCrypt
{
   private static byte[] key1 = null;
   private static byte[] key2 = null;
   

//   public ByteCrypt()
//   {
//     if ((key1 == null) || (key2 == null)) {
//       setKey("googlefeeback", "configopbinfo");
//     }
//   }
   
   
   
   public ByteCrypt(String key1,String key2){
	   setKey(key1,key2);
   }

   static void setKey(String strKey1, String strKey2)
   {
	 if(isEmpty(strKey1)||isEmpty(strKey2)){
		 throw new RuntimeException("key must not empty");
	 }
     key1 = strKey1.getBytes();
     key2 = strKey2.getBytes();
   }
   
//   public byte[] opEncryption(byte[] context)
//   {
//     int len = key1.length;
//     if (context == null)
//     {
//       return null;
//     }
//     byte[] contextEncryption = new byte[context.length];
//     
//     for (int i = 0; i < context.length; i++)
//     {
//       contextEncryption[i] = ((byte)(context[i] ^ key1[(i % len)]));
//     }
//     
//     len = key2.length;
//     
//     for (int i = 0; i < context.length; i++)
//     {
//       contextEncryption[i] = ((byte)(contextEncryption[i] ^ key2[(i % len)]));
//     }
//     return contextEncryption;
//   }
   
   public byte[] opEncryption(byte[] context)
   {
     int len = key1.length;
     if (context == null)
     {
       return null;
     }
     byte[] contextEncryption = new byte[context.length+key1.length+key2.length];
     
     for (int i = 0; i < context.length; i++)
     {
       contextEncryption[i] = ((byte)(context[i] ^ key1[(i % len)]));
     }
     
     len = key2.length;
     
     for (int i = 0; i < context.length; i++)
     {
       contextEncryption[i] = ((byte)(contextEncryption[i] ^ key2[(i % len)]));
     }
     
     for(int i=context.length;i<context.length+key1.length;i++){
    	 contextEncryption[i] = key1[i-context.length];
     }
     
     for(int i=context.length+key1.length;i<context.length+key1.length+key2.length;i++){
    	 contextEncryption[i] = key2[i-context.length-key1.length];
     }
     return contextEncryption;
   }
 
   public byte[] opDecryption(byte[] context)
   {
     int len = key2.length;
     if(context == null)
     {
       return null;
     }
     byte[] contextEncryption = new byte[context.length];
     
     for (int i = 0; i < context.length; i++)
     {
       contextEncryption[i] = ((byte)(context[i] ^ key2[(i % len)]));
     }
     
     len = key1.length;
     
     for (int i = 0; i < context.length; i++)
     {
       contextEncryption[i] = ((byte)(contextEncryption[i] ^ key1[(i % len)]));
     }
     
     return contextEncryption;
   }

   public static String getString(byte[] targetBytes)
   {
	    byte[] targets = new byte[targetBytes.length-16];
		for(int i=0;i<targets.length;i++){
			targets[i] = targetBytes[i];
		}
		
		byte[] key2Bytes = new byte[8];
		byte[] key1Bytes = new byte[8];
		
		for(int i=0;i<key2Bytes.length;i++){
			key2Bytes[i] = targetBytes[targetBytes.length-8+i];
		}
		
		for(int i=0;i<key1Bytes.length;i++){
			key1Bytes[i] = targetBytes[targetBytes.length-16+i];
		}
		
		String key2 = new String(key2Bytes);
		String key1 = new String(key1Bytes);   
	    
		System.out.println("decrypt key1:"+key1+",key2:"+key2);
		
		ByteCrypt ps = new ByteCrypt(key1,key2);
		byte[] bs = ps.opDecryption(targets);
		return new String(bs);
   }
   
   public static boolean isEmpty(String text){
	   if(text == null || text.trim().equals("")){
		   return true;
	   }
	   return false;
   }
 }
