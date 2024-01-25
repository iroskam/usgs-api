#!/usr/bin/python3
import requests

response = requests.get("https://mrdata.usgs.gov/catalog/term-search.php?thcode=5")
json = response.json()

f = open("src/main/java/pub/usgs/client/Commodities.java", "w")
f.write("package pub.usgs.client;\n")
f.write("\n")
f.write("record Commodity(String code, String label, String value){};\n")
f.write("\n")
f.write("public class Commodities {\n")

#  /**
#   * %label%
#   */
#   public static final Commodity %code% = new Commodity(%thcode%,%code%,%label%,%value%);
#
# possible duplicates as of 1/23/24
al=nb=h2o=pge=ree=False

for commodity in json:
    label = commodity['label']
    code = commodity['code']
    value = commodity['value']
    # manual duplicate removal
    if (code=='AL' and al) or (code=='NB' and nb) or (code=='H2O' and h2o) or (code=='PGE' and pge) or (code=='REE' and ree):
        print("Skipping "+code)
        continue
    if not al:
        al = code == 'AL'
    if not nb:
        nb = code == 'NB'
    if not h2o:
        h2o = code == 'H2O'
    if not pge:
        pge = code == 'PGE'
    if not ree:
        ree = code == 'REE'

    f.write("\t/**\n")
    f.write("\t* "+label+"\n")
    f.write("\t*/\n")
    f.write("\tpublic static final Commodity "+code+" = new Commodity(\""+code+"\", \""+label+"\", \""+value+"\");\n")

f.write("}")
f.close()
