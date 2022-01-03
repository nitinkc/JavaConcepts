var testStrings = ["one", "two", "three", "four"];
testStrings.sort(function(s1, s2) { return(s1.length - s2.length);});
testStrings.sort(function(s1, s2) { return(s1.charCodeAt(s1.length - 1) -
                                           s2.charCodeAt(s2.length - 1));});


