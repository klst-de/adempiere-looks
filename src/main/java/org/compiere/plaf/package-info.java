/**
 * 
 */
/*
 * @author eugen
 * 
 * Teile aus base

CompiereThemeBlueMetal extends CompiereTheme extends MetalTheme 
// es gibt ein weiteres Theme
CompiereThemeIce

MetalTheme / OceanTheme ist das default L&F Theme in java 
MetalTheme is abstract, and OceanTheme is concrete implementations. 
* java Metal gibt es noch andere Theme (Farben): Ocean, Steel, Aqua, ...
* java Nimbus hat keine Theme!


auch abstract class com.jgoodies.looks.plastic.PlasticTheme leitet sich von MetalTheme ab: extends DefaultMetalTheme extends MetalTheme

 AbstractSkyTheme extends SkyBluer extends PlasticTheme
BrownSugar extends abstract class InvertedColorTheme extends PlasticTheme
DarkStar extends abstract class InvertedColorTheme extends PlasticTheme
DesertBlue extends DesertBluer extends SkyBluer extends PlasticTheme
DesertBluer extends SkyBluer extends PlasticTheme
DesertGreen extends DesertBlue extends DesertBluer extends SkyBluer extends PlasticTheme
DesertRed extends DesertBlue extends DesertBluer extends SkyBluer extends PlasticTheme
DesertYellow extends DesertBlue extends DesertBluer extends SkyBluer extends PlasticTheme
ExperienceBlue extends DesertBluer extends SkyBluer extends PlasticTheme
ExperienceGreen extends ExperienceBlue extends DesertBluer extends SkyBluer extends PlasticTheme
ExperienceRoyale extends DesertBluer extends SkyBluer extends PlasticTheme
 abstract class InvertedColorTheme extends PlasticTheme
LightGray extends ExperienceBlue extends DesertBluer extends SkyBluer extends PlasticTheme
Silver extends ExperienceBlue extends DesertBluer extends SkyBluer extends PlasticTheme
SkyBlue extends AbstractSkyTheme extends SkyBluer extends PlasticTheme
SkyBluer extends PlasticTheme
SkyGreen extends AbstractSkyTheme extends SkyBluer extends PlasticTheme
SkyKrupp extends AbstractSkyTheme extends SkyBluer extends PlasticTheme
SkyPink extends AbstractSkyTheme extends SkyBluer extends PlasticTheme
SkyRed extends AbstractSkyTheme extends SkyBluer extends PlasticTheme
SkyYellow extends AbstractSkyTheme extends SkyBluer extends PlasticTheme

 */
package org.compiere.plaf;

