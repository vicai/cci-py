def powerset(a):
    # returns a list of all subsets of the list a
    if (len(a) == 0):
        return [[]]
    else:
        allSubsets = [ ]
        for subset in powerset(a[1:]):
            print "subset:", subset, "\n"
            print [a[0]] + subset, "\n"
            allSubsets += [subset]
            allSubsets += [[a[0]] + subset]
        return allSubsets
 
print powerset([0,1,4])