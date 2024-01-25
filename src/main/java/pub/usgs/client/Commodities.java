package pub.usgs.client;

record Commodity(String code, String label, String value){};

public class Commodities {
	/**
	* Abrasive
	*/
	public static final Commodity ABR = new Commodity("ABR", "Abrasive", "Abrasive");
	/**
	* Abrasive, Corundum
	*/
	public static final Commodity ABR_C = new Commodity("ABR_C", "Abrasive, Corundum", "Abrasive, Corundum");
	/**
	* Abrasive, Emery
	*/
	public static final Commodity ABR_E = new Commodity("ABR_E", "Abrasive, Emery", "Abrasive, Emery");
	/**
	* Abrasive, Garnet
	*/
	public static final Commodity ABR_G = new Commodity("ABR_G", "Abrasive, Garnet", "Abrasive, Garnet");
	/**
	* Aggregate, Light Weight
	*/
	public static final Commodity LWA = new Commodity("LWA", "Aggregate, Light Weight", "Aggregate, Light Weight");
	/**
	* Aluminium
	*/
	public static final Commodity AL = new Commodity("AL", "Aluminium", "Aluminum");
	/**
	* Aluminum, Contained Or Metal
	*/
	public static final Commodity AL_C = new Commodity("AL_C", "Aluminum, Contained Or Metal", "Aluminum, Contained Or Metal");
	/**
	* Aluminum, High Alumina Clay
	*/
	public static final Commodity AL_CLY = new Commodity("AL_CLY", "Aluminum, High Alumina Clay", "Aluminum, High Alumina Clay");
	/**
	* Andalusite
	*/
	public static final Commodity AND = new Commodity("AND", "Andalusite", "Andalusite");
	/**
	* Antimony
	*/
	public static final Commodity SB = new Commodity("SB", "Antimony", "Antimony");
	/**
	* Arsenic
	*/
	public static final Commodity AS = new Commodity("AS", "Arsenic", "Arsenic");
	/**
	* Asbestos
	*/
	public static final Commodity ASB = new Commodity("ASB", "Asbestos", "Asbestos");
	/**
	* Ash
	*/
	public static final Commodity ASH = new Commodity("ASH", "Ash", "Ash");
	/**
	* Barium-Barite
	*/
	public static final Commodity BA = new Commodity("BA", "Barium-Barite", "Barium-Barite");
	/**
	* Beryllium
	*/
	public static final Commodity BE = new Commodity("BE", "Beryllium", "Beryllium");
	/**
	* Bismuth
	*/
	public static final Commodity BI = new Commodity("BI", "Bismuth", "Bismuth");
	/**
	* Boron-Borates
	*/
	public static final Commodity B = new Commodity("B", "Boron-Borates", "Boron-Borates");
	/**
	* Bromine
	*/
	public static final Commodity BR = new Commodity("BR", "Bromine", "Bromine");
	/**
	* Cadmium
	*/
	public static final Commodity CD = new Commodity("CD", "Cadmium", "Cadmium");
	/**
	* Calcium
	*/
	public static final Commodity CA = new Commodity("CA", "Calcium", "Calcium");
	/**
	* Carbon Dioxide
	*/
	public static final Commodity CO2 = new Commodity("CO2", "Carbon Dioxide", "Carbon Dioxide");
	/**
	* Cement Rock
	*/
	public static final Commodity CEM = new Commodity("CEM", "Cement Rock", "Cement Rock");
	/**
	* Cesium
	*/
	public static final Commodity CS = new Commodity("CS", "Cesium", "Cesium");
	/**
	* Chlorine
	*/
	public static final Commodity CL = new Commodity("CL", "Chlorine", "Chlorine");
	/**
	* Chromium
	*/
	public static final Commodity CR = new Commodity("CR", "Chromium", "Chromium");
	/**
	* Chromium, Ferrochrome
	*/
	public static final Commodity CR_F = new Commodity("CR_F", "Chromium, Ferrochrome", "Chromium, Ferrochrome");
	/**
	* Clay
	*/
	public static final Commodity CLY = new Commodity("CLY", "Clay", "Clay");
	/**
	* Clay, Ball Clay
	*/
	public static final Commodity CLY_BC = new Commodity("CLY_BC", "Clay, Ball Clay", "Clay, Ball Clay");
	/**
	* Clay, Bentonite
	*/
	public static final Commodity CLY_BN = new Commodity("CLY_BN", "Clay, Bentonite", "Clay, Bentonite");
	/**
	* Clay, Bloating Material
	*/
	public static final Commodity CLY_BM = new Commodity("CLY_BM", "Clay, Bloating Material", "Clay, Bloating Material");
	/**
	* Clay, Brick
	*/
	public static final Commodity CLY_BK = new Commodity("CLY_BK", "Clay, Brick", "Clay, Brick");
	/**
	* Clay, Chlorite
	*/
	public static final Commodity CLY_C = new Commodity("CLY_C", "Clay, Chlorite", "Clay, Chlorite");
	/**
	* Clay, Fire (Refractory)
	*/
	public static final Commodity CLY_FR = new Commodity("CLY_FR", "Clay, Fire (Refractory)", "Clay, Fire (Refractory)");
	/**
	* Clay, Fullers Earth
	*/
	public static final Commodity CLY_FE = new Commodity("CLY_FE", "Clay, Fullers Earth", "Clay, Fullers Earth");
	/**
	* Clay, General
	*/
	public static final Commodity CLY_GN = new Commodity("CLY_GN", "Clay, General", "Clay, General");
	/**
	* Clay, Glauconite
	*/
	public static final Commodity CLY_GL = new Commodity("CLY_GL", "Clay, Glauconite", "Clay, Glauconite");
	/**
	* Clay, Hectorite
	*/
	public static final Commodity CLY_H = new Commodity("CLY_H", "Clay, Hectorite", "Clay, Hectorite");
	/**
	* Clay, Kaolin
	*/
	public static final Commodity CLY_K = new Commodity("CLY_K", "Clay, Kaolin", "Clay, Kaolin");
	/**
	* Clay, Montmorillonite
	*/
	public static final Commodity CLY_M = new Commodity("CLY_M", "Clay, Montmorillonite", "Clay, Montmorillonite");
	/**
	* Coal
	*/
	public static final Commodity COA = new Commodity("COA", "Coal", "Coal");
	/**
	* Coal, Anthracite
	*/
	public static final Commodity COA_A = new Commodity("COA_A", "Coal, Anthracite", "Coal, Anthracite");
	/**
	* Coal, Bituminous
	*/
	public static final Commodity COA_B = new Commodity("COA_B", "Coal, Bituminous", "Coal, Bituminous");
	/**
	* Coal, Lignite
	*/
	public static final Commodity COA_L = new Commodity("COA_L", "Coal, Lignite", "Coal, Lignite");
	/**
	* Coal, Subbituminous
	*/
	public static final Commodity COA_S = new Commodity("COA_S", "Coal, Subbituminous", "Coal, Subbituminous");
	/**
	* Cobalt
	*/
	public static final Commodity CO = new Commodity("CO", "Cobalt", "Cobalt");
	/**
	* Columbium
	*/
	public static final Commodity NB = new Commodity("NB", "Columbium", "Niobium");
	/**
	* Commodity
	*/
	public static final Commodity root = new Commodity("root", "Commodity", "Commodity");
	/**
	* Copper
	*/
	public static final Commodity CU = new Commodity("CU", "Copper", "Copper");
	/**
	* Copper, Oxide
	*/
	public static final Commodity CU_O = new Commodity("CU_O", "Copper, Oxide", "Copper, Oxide");
	/**
	* Copper, Sulfide
	*/
	public static final Commodity CU_S = new Commodity("CU_S", "Copper, Sulfide", "Copper, Sulfide");
	/**
	* Diatomite
	*/
	public static final Commodity DIT = new Commodity("DIT", "Diatomite", "Diatomite");
	/**
	* Dolomite
	*/
	public static final Commodity DOL = new Commodity("DOL", "Dolomite", "Dolomite");
	/**
	* Energy
	*/
	public static final Commodity _E = new Commodity("_E", "Energy", "Energy");
	/**
	* Feldspar
	*/
	public static final Commodity FLD = new Commodity("FLD", "Feldspar", "Feldspar");
	/**
	* Flagstone
	*/
	public static final Commodity STN_F = new Commodity("STN_F", "Flagstone", "Flagstone");
	/**
	* Flint
	*/
	public static final Commodity FLN = new Commodity("FLN", "Flint", "Flint");
	/**
	* Fluorine-Fluorite
	*/
	public static final Commodity F = new Commodity("F", "Fluorine-Fluorite", "Fluorine-Fluorite");
	/**
	* Gallium
	*/
	public static final Commodity GA = new Commodity("GA", "Gallium", "Gallium");
	/**
	* Gemstone
	*/
	public static final Commodity GEM = new Commodity("GEM", "Gemstone", "Gemstone");
	/**
	* Gemstone, Diamond
	*/
	public static final Commodity GEM_D = new Commodity("GEM_D", "Gemstone, Diamond", "Gemstone, Diamond");
	/**
	* Gemstone, Emerald
	*/
	public static final Commodity GEM_E = new Commodity("GEM_E", "Gemstone, Emerald", "Gemstone, Emerald");
	/**
	* Gemstone, Jade
	*/
	public static final Commodity GEM_J = new Commodity("GEM_J", "Gemstone, Jade", "Gemstone, Jade");
	/**
	* Gemstone, Ruby
	*/
	public static final Commodity GEM_R = new Commodity("GEM_R", "Gemstone, Ruby", "Gemstone, Ruby");
	/**
	* Gemstone, Sapphire
	*/
	public static final Commodity GEM_SA = new Commodity("GEM_SA", "Gemstone, Sapphire", "Gemstone, Sapphire");
	/**
	* Gemstone, Semiprecious
	*/
	public static final Commodity GEM_SP = new Commodity("GEM_SP", "Gemstone, Semiprecious", "Gemstone, Semiprecious");
	/**
	* Geothermal
	*/
	public static final Commodity GEO = new Commodity("GEO", "Geothermal", "Geothermal");
	/**
	* Germanium
	*/
	public static final Commodity GE = new Commodity("GE", "Germanium", "Germanium");
	/**
	* Gold
	*/
	public static final Commodity AU = new Commodity("AU", "Gold", "Gold");
	/**
	* Gold, Refinery
	*/
	public static final Commodity AU_R = new Commodity("AU_R", "Gold, Refinery", "Gold, Refinery");
	/**
	* Granite
	*/
	public static final Commodity GRT = new Commodity("GRT", "Granite", "Granite");
	/**
	* Graphite
	*/
	public static final Commodity GRF = new Commodity("GRF", "Graphite", "Graphite");
	/**
	* Graphite, Carbon
	*/
	public static final Commodity GRF_C = new Commodity("GRF_C", "Graphite, Carbon", "Graphite, Carbon");
	/**
	* ground water
	*/
	public static final Commodity H2O = new Commodity("H2O", "ground water", "Water");
	/**
	* Gypsum-Anhydrite
	*/
	public static final Commodity GYP = new Commodity("GYP", "Gypsum-Anhydrite", "Gypsum-Anhydrite");
	/**
	* Gypsum-Anhydrite, Alabaster
	*/
	public static final Commodity GYP_A = new Commodity("GYP_A", "Gypsum-Anhydrite, Alabaster", "Gypsum-Anhydrite, Alabaster");
	/**
	* Hafnium
	*/
	public static final Commodity HF = new Commodity("HF", "Hafnium", "Hafnium");
	/**
	* Helium
	*/
	public static final Commodity HE = new Commodity("HE", "Helium", "Helium");
	/**
	* Hydrogen
	*/
	public static final Commodity H = new Commodity("H", "Hydrogen", "Hydrogen");
	/**
	* Indium
	*/
	public static final Commodity IN = new Commodity("IN", "Indium", "Indium");
	/**
	* Iodine
	*/
	public static final Commodity I = new Commodity("I", "Iodine", "Iodine");
	/**
	* Iridium
	*/
	public static final Commodity PGE_IR = new Commodity("PGE_IR", "Iridium", "Iridium");
	/**
	* Iron
	*/
	public static final Commodity FE = new Commodity("FE", "Iron", "Iron");
	/**
	* Iron, Pig Iron
	*/
	public static final Commodity FE_P = new Commodity("FE_P", "Iron, Pig Iron", "Iron, Pig Iron");
	/**
	* Iron, Pyrite
	*/
	public static final Commodity FE_PYR = new Commodity("FE_PYR", "Iron, Pyrite", "Iron, Pyrite");
	/**
	* Kyanite
	*/
	public static final Commodity KYN = new Commodity("KYN", "Kyanite", "Kyanite");
	/**
	* Lead
	*/
	public static final Commodity PB = new Commodity("PB", "Lead", "Lead");
	/**
	* Lead, Refiner
	*/
	public static final Commodity PB_R = new Commodity("PB_R", "Lead, Refiner", "Lead, Refiner");
	/**
	* Lead, Smelter
	*/
	public static final Commodity PB_S = new Commodity("PB_S", "Lead, Smelter", "Lead, Smelter");
	/**
	* Limestone
	*/
	public static final Commodity LST = new Commodity("LST", "Limestone", "Limestone");
	/**
	* Limestone, Dimension
	*/
	public static final Commodity LST_D = new Commodity("LST_D", "Limestone, Dimension", "Limestone, Dimension");
	/**
	* Limestone, High Calcium
	*/
	public static final Commodity LST_C = new Commodity("LST_C", "Limestone, High Calcium", "Limestone, High Calcium");
	/**
	* Limestone, Ultra Pure
	*/
	public static final Commodity LST_P = new Commodity("LST_P", "Limestone, Ultra Pure", "Limestone, Ultra Pure");
	/**
	* Lithium
	*/
	public static final Commodity LI = new Commodity("LI", "Lithium", "Lithium");
	/**
	* Magnesite
	*/
	public static final Commodity MG = new Commodity("MG", "Magnesite", "Magnesite");
	/**
	* Manganese
	*/
	public static final Commodity MN = new Commodity("MN", "Manganese", "Manganese");
	/**
	* Manganese, Ferromanganese
	*/
	public static final Commodity MN_F = new Commodity("MN_F", "Manganese, Ferromanganese", "Manganese, Ferromanganese");
	/**
	* Marble
	*/
	public static final Commodity MBL = new Commodity("MBL", "Marble", "Marble");
	/**
	* Mercury
	*/
	public static final Commodity HG = new Commodity("HG", "Mercury", "Mercury");
	/**
	* Metal
	*/
	public static final Commodity _M = new Commodity("_M", "Metal", "Metal");
	/**
	* Mica
	*/
	public static final Commodity MIC = new Commodity("MIC", "Mica", "Mica");
	/**
	* Mineral Pigments
	*/
	public static final Commodity MPG = new Commodity("MPG", "Mineral Pigments", "Mineral Pigments");
	/**
	* Molybdenum
	*/
	public static final Commodity MO = new Commodity("MO", "Molybdenum", "Molybdenum");
	/**
	* Natural Gas
	*/
	public static final Commodity GAS = new Commodity("GAS", "Natural Gas", "Natural Gas");
	/**
	* Nickel
	*/
	public static final Commodity NI = new Commodity("NI", "Nickel", "Nickel");
	/**
	* Nickel, Laterite
	*/
	public static final Commodity NI_L = new Commodity("NI_L", "Nickel, Laterite", "Nickel, Laterite");
	/**
	* Nickel, Refiner
	*/
	public static final Commodity NI_R = new Commodity("NI_R", "Nickel, Refiner", "Nickel, Refiner");
	/**
	* Nickel, Smelter
	*/
	public static final Commodity NI_S = new Commodity("NI_S", "Nickel, Smelter", "Nickel, Smelter");
	/**
	* Nitrogen-Nitrates
	*/
	public static final Commodity N = new Commodity("N", "Nitrogen-Nitrates", "Nitrogen-Nitrates");
	/**
	* Nonmetal
	*/
	public static final Commodity _N = new Commodity("_N", "Nonmetal", "Nonmetal");
	/**
	* Olivine
	*/
	public static final Commodity OLV = new Commodity("OLV", "Olivine", "Olivine");
	/**
	* Osmium
	*/
	public static final Commodity PGE_OS = new Commodity("PGE_OS", "Osmium", "Osmium");
	/**
	* Palladium
	*/
	public static final Commodity PGE_PD = new Commodity("PGE_PD", "Palladium", "Palladium");
	/**
	* Peat
	*/
	public static final Commodity PEA = new Commodity("PEA", "Peat", "Peat");
	/**
	* Perlite
	*/
	public static final Commodity PER = new Commodity("PER", "Perlite", "Perlite");
	/**
	* Petroleum (Oil)
	*/
	public static final Commodity OIL = new Commodity("OIL", "Petroleum (Oil)", "Petroleum (Oil)");
	/**
	* Petroleum (Oil), Gilsonite
	*/
	public static final Commodity OIL_G = new Commodity("OIL_G", "Petroleum (Oil), Gilsonite", "Petroleum (Oil), Gilsonite");
	/**
	* Petroleum (Oil), Oil Sands
	*/
	public static final Commodity OIL_SA = new Commodity("OIL_SA", "Petroleum (Oil), Oil Sands", "Petroleum (Oil), Oil Sands");
	/**
	* Petroleum (Oil), Oil Shale
	*/
	public static final Commodity OIL_SH = new Commodity("OIL_SH", "Petroleum (Oil), Oil Shale", "Petroleum (Oil), Oil Shale");
	/**
	* Petroleum (Oil), Rock Asphalt
	*/
	public static final Commodity OIL_R = new Commodity("OIL_R", "Petroleum (Oil), Rock Asphalt", "Petroleum (Oil), Rock Asphalt");
	/**
	* PGE
	*/
	public static final Commodity PGE = new Commodity("PGE", "PGE", "platinum-group elements");
	/**
	* Phosphorus-Phosphates
	*/
	public static final Commodity P = new Commodity("P", "Phosphorus-Phosphates", "Phosphorus-Phosphates");
	/**
	* Platinum
	*/
	public static final Commodity PGE_PT = new Commodity("PGE_PT", "Platinum", "Platinum");
	/**
	* Potassium
	*/
	public static final Commodity K = new Commodity("K", "Potassium", "Potassium");
	/**
	* Potassium, Alum
	*/
	public static final Commodity K_A = new Commodity("K_A", "Potassium, Alum", "Potassium, Alum");
	/**
	* Pumice
	*/
	public static final Commodity PUM = new Commodity("PUM", "Pumice", "Pumice");
	/**
	* Pyrite
	*/
	public static final Commodity PYR = new Commodity("PYR", "Pyrite", "Pyrite");
	/**
	* Pyrophyllite
	*/
	public static final Commodity PPY = new Commodity("PPY", "Pyrophyllite", "Pyrophyllite");
	/**
	* Quartz
	*/
	public static final Commodity QTZ = new Commodity("QTZ", "Quartz", "Quartz");
	/**
	* Radium
	*/
	public static final Commodity RA = new Commodity("RA", "Radium", "Radium");
	/**
	* rare earth elements
	*/
	public static final Commodity REE = new Commodity("REE", "rare earth elements", "rare earth elements");
	/**
	* Rhenium
	*/
	public static final Commodity RE = new Commodity("RE", "Rhenium", "Rhenium");
	/**
	* Rhodium
	*/
	public static final Commodity PGE_RH = new Commodity("PGE_RH", "Rhodium", "Rhodium");
	/**
	* Rubidium
	*/
	public static final Commodity RB = new Commodity("RB", "Rubidium", "Rubidium");
	/**
	* Ruthenium
	*/
	public static final Commodity PGE_RU = new Commodity("PGE_RU", "Ruthenium", "Ruthenium");
	/**
	* Sand
	*/
	public static final Commodity SD = new Commodity("SD", "Sand", "Sand");
	/**
	* Sand and Gravel
	*/
	public static final Commodity SDG = new Commodity("SDG", "Sand and Gravel", "Sand and Gravel");
	/**
	* Scandium
	*/
	public static final Commodity SC = new Commodity("SC", "Scandium", "Scandium");
	/**
	* Selenium
	*/
	public static final Commodity SE = new Commodity("SE", "Selenium", "Selenium");
	/**
	* Silica
	*/
	public static final Commodity SIL = new Commodity("SIL", "Silica", "Silica");
	/**
	* Silica, Ferrosilicon
	*/
	public static final Commodity SIL_F = new Commodity("SIL_F", "Silica, Ferrosilicon", "Silica, Ferrosilicon");
	/**
	* Silver
	*/
	public static final Commodity AG = new Commodity("AG", "Silver", "Silver");
	/**
	* Silver, Refinery
	*/
	public static final Commodity AG_R = new Commodity("AG_R", "Silver, Refinery", "Silver, Refinery");
	/**
	* Slate
	*/
	public static final Commodity SLA = new Commodity("SLA", "Slate", "Slate");
	/**
	* Sodium
	*/
	public static final Commodity NA = new Commodity("NA", "Sodium", "Sodium");
	/**
	* Sodium, Halite
	*/
	public static final Commodity NA_H = new Commodity("NA_H", "Sodium, Halite", "Sodium, Halite");
	/**
	* Sodium, Salt
	*/
	public static final Commodity NA_S = new Commodity("NA_S", "Sodium, Salt", "Sodium, Salt");
	/**
	* Staurolite
	*/
	public static final Commodity STA = new Commodity("STA", "Staurolite", "Staurolite");
	/**
	* Stone
	*/
	public static final Commodity STN = new Commodity("STN", "Stone", "Stone");
	/**
	* Stone, Crushed/Broken
	*/
	public static final Commodity STN_C = new Commodity("STN_C", "Stone, Crushed/Broken", "Stone, Crushed/Broken");
	/**
	* Stone, Dimension
	*/
	public static final Commodity STN_D = new Commodity("STN_D", "Stone, Dimension", "Stone, Dimension");
	/**
	* Strontium
	*/
	public static final Commodity SR = new Commodity("SR", "Strontium", "Strontium");
	/**
	* Sulfides
	*/
	public static final Commodity SUL = new Commodity("SUL", "Sulfides", "Sulfides");
	/**
	* Sulfur
	*/
	public static final Commodity S = new Commodity("S", "Sulfur", "Sulfur");
	/**
	* Sulfur, Iron Pyrite
	*/
	public static final Commodity S_P = new Commodity("S_P", "Sulfur, Iron Pyrite", "Sulfur, Iron Pyrite");
	/**
	* Sulfur, Sulfuric Acid
	*/
	public static final Commodity S_A = new Commodity("S_A", "Sulfur, Sulfuric Acid", "Sulfur, Sulfuric Acid");
	/**
	* Talc-Soapstone
	*/
	public static final Commodity TLC = new Commodity("TLC", "Talc-Soapstone", "Talc-Soapstone");
	/**
	* Tantalum
	*/
	public static final Commodity TA = new Commodity("TA", "Tantalum", "Tantalum");
	/**
	* Tantalum, Tin Slag
	*/
	public static final Commodity TA_S = new Commodity("TA_S", "Tantalum, Tin Slag", "Tantalum, Tin Slag");
	/**
	* Tellurium
	*/
	public static final Commodity TE = new Commodity("TE", "Tellurium", "Tellurium");
	/**
	* Thallium
	*/
	public static final Commodity TL = new Commodity("TL", "Thallium", "Thallium");
	/**
	* Thorium
	*/
	public static final Commodity TH = new Commodity("TH", "Thorium", "Thorium");
	/**
	* Tin
	*/
	public static final Commodity SN = new Commodity("SN", "Tin", "Tin");
	/**
	* Tin, Tailings
	*/
	public static final Commodity SN_T = new Commodity("SN_T", "Tin, Tailings", "Tin, Tailings");
	/**
	* Titanium
	*/
	public static final Commodity TI = new Commodity("TI", "Titanium", "Titanium");
	/**
	* Titanium, Heavy Minerals
	*/
	public static final Commodity TI_HM = new Commodity("TI_HM", "Titanium, Heavy Minerals", "Titanium, Heavy Minerals");
	/**
	* Titanium, Ilmenite
	*/
	public static final Commodity TI_I = new Commodity("TI_I", "Titanium, Ilmenite", "Titanium, Ilmenite");
	/**
	* Titanium, Metal
	*/
	public static final Commodity TI_M = new Commodity("TI_M", "Titanium, Metal", "Titanium, Metal");
	/**
	* Titanium, Pigment
	*/
	public static final Commodity TI_P = new Commodity("TI_P", "Titanium, Pigment", "Titanium, Pigment");
	/**
	* Titanium, Rutile
	*/
	public static final Commodity TI_R = new Commodity("TI_R", "Titanium, Rutile", "Titanium, Rutile");
	/**
	* Travertine
	*/
	public static final Commodity TRA = new Commodity("TRA", "Travertine", "Travertine");
	/**
	* Tungsten
	*/
	public static final Commodity W = new Commodity("W", "Tungsten", "Tungsten");
	/**
	* Tungsten, Mill Concentrate
	*/
	public static final Commodity W_C = new Commodity("W_C", "Tungsten, Mill Concentrate", "Tungsten, Mill Concentrate");
	/**
	* Tungsten, Refinery
	*/
	public static final Commodity W_R = new Commodity("W_R", "Tungsten, Refinery", "Tungsten, Refinery");
	/**
	* Uranium
	*/
	public static final Commodity U = new Commodity("U", "Uranium", "Uranium");
	/**
	* Vanadium
	*/
	public static final Commodity V = new Commodity("V", "Vanadium", "Vanadium");
	/**
	* Vermiculite
	*/
	public static final Commodity VRM = new Commodity("VRM", "Vermiculite", "Vermiculite");
	/**
	* Volcanic Materials
	*/
	public static final Commodity VOL = new Commodity("VOL", "Volcanic Materials", "Volcanic Materials");
	/**
	* Wollastonite
	*/
	public static final Commodity WOL = new Commodity("WOL", "Wollastonite", "Wollastonite");
	/**
	* Zeolites
	*/
	public static final Commodity ZEO = new Commodity("ZEO", "Zeolites", "Zeolites");
	/**
	* Zinc
	*/
	public static final Commodity ZN = new Commodity("ZN", "Zinc", "Zinc");
	/**
	* Zinc, Refiner
	*/
	public static final Commodity ZN_R = new Commodity("ZN_R", "Zinc, Refiner", "Zinc, Refiner");
	/**
	* Zinc, Smelter
	*/
	public static final Commodity ZN_S = new Commodity("ZN_S", "Zinc, Smelter", "Zinc, Smelter");
	/**
	* Zirconium
	*/
	public static final Commodity ZR = new Commodity("ZR", "Zirconium", "Zirconium");
}