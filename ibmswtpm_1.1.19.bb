SUMMARY = "IBM TPM Simulator based on TPM 2.0"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"
DEPENDS = "openssl"
SRC_URI = "${SOURCEFORGE_MIRROR}/ibmswtpm2/ibmtpm1119.tar.gz \
	   file://0001-Adding-CMakeList.txt.patch"

SRC_URI[md5sum] = "cf20b9080b4692984c8389c5052fe68a"
SRC_URI[sha256sum] = "b9eef79904e276aeaed2a6b9e4021442ef4d7dfae4adde2473bef1a6a4cd10fb"

EXTRA_OECMAKE+=" -DCMAKE_SYSROOT=${STAGING_DIR_TARGET}"

S = "${WORKDIR}/src"

inherit cmake

do_install () {
	install -d ${D}${base_bindir}
  	install -m 0755 ibmswtpm ${D}${base_bindir}/ibmswtpm
}

