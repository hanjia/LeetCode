package org.hanjia.leetcode.stack;

import java.util.Stack;

/**
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * 
 * @author hanjia
 *
 */
public class Problem71_SimplifyPath {
	public String simplifyPath(String path) {
        if(path == null||path.length()==0)
             return path;
         
         Stack<String> stack = new Stack<String>();
         String[] list = path.split("/");
         
         for(int i=0; i<list.length; i++){
             if(list[i].equals(".")||list[i].length()==0)
                 continue;
             else if(!list[i].equals(".."))
                 stack.push(list[i]);
             else{
                 if(!stack.isEmpty())
                     stack.pop();
             }
         }
         
         StringBuilder res = new StringBuilder();
         
         Stack<String> temp = new Stack<String>();
         while(!stack.isEmpty())  
             temp.push(stack.pop());
         
         while(!temp.isEmpty())
             res.append("/"+temp.pop());
         
         if(res.length()==0)
             res.append("/");
         
         return res.toString();
    }
}
