/**
 * module-info
 */
module de.carne.swt.browseradapater {
	requires transitive org.eclipse.jdt.annotation;
	requires transitive de.carne.swt;

	requires com.sun.jna;

	exports de.carne.swt.browseradapter;
	exports de.carne.swt.browseradapter.spi;
}
