package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainVisitMap = new HashMap<>();

        for (String CPD : cpdomains) {
            String[] currCPD = CPD.split(" ");
            int currCount = Integer.parseInt(currCPD[0]);
            String[] currDomains = currCPD[1].split("\\.");
            int currDomainsLength = currDomains.length;

            for (int i = 0; i < currDomainsLength; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < currDomainsLength; j++) {
                    if (j != i) {
                        sb.append(".");
                    }
                    sb.append(currDomains[j]);
                }
                domainVisitMap.put(sb.toString(), domainVisitMap.getOrDefault(sb.toString(), 0) + currCount);
            }
        }

        List<String> ans = new ArrayList<>();

        for (String k : domainVisitMap.keySet()) {
            String ansEntry = domainVisitMap.get(k) + " " + k;
            ans.add(ansEntry);
        }

        return ans;
    }
}
//A website domain "discuss.leetcode.com" consists of various subdomains.
// At the top level, we have "com", at the next level, we have "leetcode.com"
// and at the lowest level, "discuss.leetcode.com". When we visit a domain
// like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
//
//A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3"
// or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.
//
//For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that
// discuss.leetcode.com was visited 9001 times.
//Given an array of count-paired domains cpdomains, return an array of the count-paired
// domains of each subdomain in the input. You may return the answer in any order.