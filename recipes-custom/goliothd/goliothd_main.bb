DESCRIPTION = "Golioth Linux Daemon"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE"

SRC_URI = "git://github.com/beriberikix/goliothd.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"
SRC_URI[sha256sum] = "99212e1eb52d002add8cae557a1f85be783d533938cf67f381bd74536d90e93e"

S = "${WORKDIR}/goliothd"

DEPENDS = "cmake-native openssl"

do_compile() {
    chmod +x build.sh
    ./build.sh
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/goliothd ${D}${bindir}
}

FILES_${PN} = "${bindir}/goliothd"