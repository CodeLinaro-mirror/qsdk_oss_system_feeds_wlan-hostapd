SUMMARY = "hostapd daemon"
LICENSE = "BSD-3-Clause"
SECTION = "network"
LIC_FILES_CHKSUM = "file://COPYING;md5=279b4f5abb9c153c285221855ddb78cc"
PKG_NAME = "hostapd"
PV = "2_10"

FILESEXTRAPATHS_append := "${THISDIR}/package/network/services/hostapd/patches:"
FILESEXTRAPATHS_append := "${THISDIR}/package/network/services/hostapd/files:"

SRC_URI = "git://w1.fi/hostap.git;nobranch=1 \
	file://hostapd-mesh.config \
	file://wpa_supplicant-mesh.config \
	file://120-daemonize_fix.patch \
	file://130-no_eapol_fix.patch \
	file://140-disable_bridge_packet_workaround.patch \
	file://200-multicall.patch \
	file://300-noscan.patch \
	file://310-rescan_immediately.patch \
	file://320-optional_rfkill.patch \
	file://330-nl80211_fix_set_freq.patch \
	file://350-nl80211_del_beacon_bss.patch \
	file://380-disable_ctrl_iface_mib.patch \
	file://390-wpa_ie_cap_workaround.patch \
	file://400-wps_single_auth_enc_type.patch \
	file://410-limit_debug_messages.patch \
	file://420-indicate-features.patch \
	file://430-hostapd_cli_ifdef.patch \
	file://431-wpa_cli_ifdef.patch \
	file://450-scan_wait.patch \
	file://460-wpa_supplicant-add-new-config-params-to-be-used-with.patch \
	file://461-driver_nl80211-use-new-parameters-during-ibss-join.patch \
	file://462-wpa_s-support-htmode-param.patch \
	file://501-hostapd-fix-compile-warnings-for-macsec.patch \
	file://502-hostapd-support-802.1x-plug-re-establish-macsec-link.patch \
	file://600-ubus_support.patch \
	file://a00-004-Add-provision-to-test-RADAR-detection-probablity-in-.patch \
	file://b00-001-hostapd-fix-an-issue-related-with-wpa_group_state.patch \
	file://b00-004-hostap-fix-compilation-issue.patch \
	file://b00-014-hostapd-add-ht40-allow-map.patch \
	file://b00-029-hostapd-disable-MAC-ACL-if-WPS-enabled.patch \
	file://b00-034-hostapd-Add-max-rate-information-into-STATUS-and-STA.patch \
	file://b00-036-hostapd-disable-40mhz-scan.patch \
	file://c00-002-hostapd-he-update-nl-header.patch \
	file://c00-010-hostapd-fix-enabling-he-in-5G.patch \
	file://c00-011-hostapd-add-mbo-support.patch \
	file://d00-002-set-supp-chan-width-for-40mghz.patch \
	file://d00-003-wpa-supplicant-override-HE-toVHT-2G.patch \
	file://d00-007-fixing-warning.patch \
	file://d00-009-hostapd-update-muedca-params.patch \
	file://e00-003-hostapd-chan-switch-6ghz.patch \
	file://e00-014-hostapd-update-cfs0-and-cfs1-for-160MHz.patch \
	file://f00-001-bss-coloring-add-support-for-handling-collision-events-and-triggering-CCA.patch \
	file://f00-002-bss_coloring-add-the-code-required-to-generate-the-CCA-IE.patch \
	file://f00-002-hostap-Move-acl-related-code-to-generic-to-be-used-for-mesh.patch \
	file://f00-003-Extend-acl-config-support-to-mesh.patch \
	file://f00-003-bss-coloring-disable-BSS-color-during-CCA.patch \
	file://f00-004-bss-coloring-add-the-switch_color-handler-to-the-nl80211-driver.patch \
	file://f00-004-mesh-Dynamic-MAC-ACL-management-over-control-interface.patch \
	file://f00-005-bss-coloring-handle-the-collision-and-CCA-events-coming-from-the-kernel.patch \
	file://f00-006-bss_coloring-allow-using-a-random-starting-color.patch \
	file://f00-007-bss_coloring-add-intelligence-color-choose-in-CCA.patch \
	file://f00-008-bss_coloring_add_support_to_change_bss_color_by_user.patch \
	file://f00-009-add-bcca-IE-with-countdown-zero-in-color-change-beacon.patch \
	file://f00-010-bss_coloring-check-free-color-periodically.patch \
	file://g00-003-hostapd-fix-int-in-bool-context-Werror.patch \
	file://g00-004-hostapd-Initilize-chan-for-second-80-mhz-to-zero.patch \
	file://h00-001-wpa_supplicant-add-mesh-ID-IE-only-for-mesh-mode.patch \
	file://h00-002-hostapd-Enable-HE40-support-in-2G-11s-mesh.patch \
	file://h00-003-hostapd-allow-AP_VLAN-creation-for-dynamic-VLAN.patch \
	file://h00-004-hostapd-Add-support-for-beacon-tx-mode.patch \
	file://h00-007-b-hostapd-Fix-HE-chan-switch-command-to-use-proper-BW.patch \
	file://h00-007-hostapd-Setting-Spectrum-Management-bit-for-chan-swi.patch \
	file://h00-008-a-add-support-for-6ghz-tpc.patch \
	file://h00-008-b-add-support-for-6ghz-tpc.patch \
	file://h00-008-c-add-support-for-6ghz-tpc.patch \
	file://h00-008-d-add-support-for-6ghz-tpc.patch \
	file://h00-008-e-Fill-6G-TPE-IE-for-non-US-countries.patch \
	file://i00-001-compile-fix.patch \
	file://j00-001-hostapd-update-missing-5.9GHz-channels.patch \
	file://k00-001-hostapd-cli-allowed-bw-on-each-channel.patch \
	file://k00-001-hostapd-macsec-support-gcmaes256-cipher-suite-when-participant-act-as-key-server.patch \
	file://k00-002-hostapd-Fix-channel-switch-on-6g.patch \
	file://l00-001-hostapd-avoid-filling-group-mgmt-cipher-type-in-FD-R.patch \
	file://l00-002-hostapd-fix-enabling-HE-thru-cli-in-2ghz.patch \
	file://m00-001-hostap-Avoid-adjacent-channel-selection-in-DFS-for-q.patch \
	file://n00-001-hostapd-Add-support-to-awgn-mitigation-for-6Ghz.patch \
	file://n00-001-hostapd-add-support-for-6GHz-operation.patch \
	file://n00-002-hostapd-add-support-for-6g-client-type.patch \
	file://o00-001-hostapd-fix-6GHz-chan-switch-issue.patch \
	file://p00-001-wpa-supplicant-support-5dot9-channels-in-mesh-160mhz.patch \
	file://p00-002-mesh-enable-more-160MHz-channels-in-6GHz.patch \
	file://p00-003-hostapd-add-acs_exclude_6ghz_non_psc-option-for-acs-.patch \
	file://q00-001-crypto-Remove-unused-crypto_ec_point_solve_y_coord.patch \
	file://q00-002-EAP-pwd-Derive-the-y-coordinate-for-PWE-with-own-imp.patch \
	file://q00-003-SAE-Derive-the-y-coordinate-for-PWE-with-own-impleme.patch \
	file://q00-004-SAE-Move-sqrt-implementation-into-a-helper-function.patch \
	file://q00-005-EAP-pwd-Fix-the-prefix-in-a-debug-message.patch \
	file://q003-001-hostapd-Add-config-to-truncate-ext-capabilities.patch \
	file://q01-001-mbssid-add-configuration-options.patch \
	file://q01-001-tests-Initial-EHT-testing.patch \
	file://q01-002-mbssid-retrieve-driver-capabilities.patch \
	file://q01-003-mbssid-configure-all-BSSes-before-beacon-setup.patch \
	file://q01-004-mbssid-get-and-set-configuration-parameters.patch \
	file://q01-005-mbssid-add-multiple-BSSID-elements.patch \
	file://q01-006-mbssid-add-MBSSID-configuration-element.patch \
	file://q01-007-mbssid-add-non-inheritance-element.patch \
	file://q01-008-mbssid-make-the-AID-space-shared.patch \
	file://q01-009-mbssid-set-extended-capabilities.patch \
	file://q01-010-mbssid-DTIM-period-configuration-for-EMA-AP.patch \
	file://q01-011-mbssid-hidden-SSID-support.patch \
	file://q01-012-mbssid-process-known-BSSID-element.patch \
	file://q01-013-mbssid-add-nl80211-support.patch \
	file://q01-014-mbssid-RNR-for-EMA-AP.patch \
	file://q01-015-mbssid-Netlink-changes-for-RNR-offsets.patch \
	file://q01-016-mbssid-support-extended-rates-in-non-tx-profiles.patch \
	file://q02-001-hostapd-fix-unsol-config.patch \
	file://q02-001-nl80211-sync-kernel-definitions.patch \
	file://q02-002-eht-define-EHT-elements.patch \
	file://q02-003-eht-configuration-options-to-enable-disable-the-supp.patch \
	file://q02-004-eht-operating-channel-width-configuration.patch \
	file://q02-005-eht-beamforming-capabilities-configuration.patch \
	file://q02-006-eht-macro-for-320-MHZ-channel-width.patch \
	file://q02-007-eht-support-for-operating-class-137.patch \
	file://q02-008-eht-add-capabilities-element-in-management-frames.patch \
	file://q02-009-eht-add-operation-element-in-management-frames.patch \
	file://q02-010-nl80211-parse-EHT-capabilities-passed-by-kernel.patch \
	file://q02-011-eht-parse-elements-received-in-management-frames.patch \
	file://q02-012-eht-process-association-request.patch \
	file://q02-013-eht-changes-in-STA-addition-path.patch \
	file://q02-014-nl80211-pass-station-s-EHT-capabilities-to-kernel.patch \
	file://q02-015-eht-changes-to-the-neighbor-report-element.patch \
	file://q02-016-eht-additions-in-FILS-discovery-frames.patch \
	file://q02-017-eht-additions-to-hostapd_set_freq_params.patch \
	file://q02-018-eht-support-for-channel-switch-command.patch \
	file://q02-019-eht-add-checks-for-channel-switch-announcement.patch \
	file://q02-020-eht-changes-to-channel-switch-exchange-with-driver.patch \
	file://q02-021-nl80211-check-driver-capabilities-for-beacon-rates.patch \
	file://q02-022-eht-configuration-option-for-beacon-rates.patch \
	file://q02-023-nl80211-pass-EHT-beacon-rate-configuration-to-kernel.patch \
	file://q02-024-hostapd-11BE-bringup-Fixes.patch \
	file://q02-025-hostapd-WAR-patch-for-prop-issue.patch \
	file://q02-031-ru_puncturing-retrieve-driver-support.patch \
	file://q02-032-ru_puncturing-add-configuration-option.patch \
	file://q02-033-ru_puncturing-add-bitmap-to-frequency-parameters.patch \
	file://q02-034-ru_puncturing-add-bitmap-to-EHT-operation-element.patch \
	file://q02-035-ru_puncturing-additions-to-channel-switch-command.patch \
	file://q02-036-ru_puncturing-send-bitmap-to-kernel.patch \
	file://q02-037-ulmumimo-parameter-support.patch \
	file://q02-041-acs-configuration-option-for-RU-puncturing-threshold.patch \
	file://q02-042-acs-generate-puncturing-bitmap.patch \
	file://q02-043-acs-validate-the-RU-puncturing-bitmap.patch \
	file://q02-044-01-hostapd-Add-320-MHz-support.patch \
	file://q02-044-02-ACS-Add-ACS-support-for-11be-mode.patch \
	file://q02-044-nl80211-sync-green-ap-changes.patch \
	file://q02-045-mesh_add_EHT_support.patch \
	file://q02-046-hostapd-Add-5GHz-240MHz-support.patch \
	file://q02-046-hostapd-DFS-ACS-5GHz-240MHz-support.patch \
	file://q02-046-hostapd-add-support-to-disable-channel-switch-during.patch \
	file://q02-046-wpa_supplicant-add-RU-puncturing-support.patch \
	file://q02-047-wpa_supplicant-Add-5GHz-240MHz-support-for-mesh.patch \
	file://q02-048-hostapd-Update-11be-EHT-elements-to-Draft-2.0-versio.patch \
	file://q02-048-mesh-Enable-80-160MHz-Mesh-DFS-channels.patch \
	file://q02-049-hostapd-fix-channel-switch-in-eht-40mhz-bandwidth-fa.patch \
	file://q02-049-hostapd-fix-he40-eht40-bringup-with-acs.patch \
	file://q02-050-hostapd-Add-freq-info-in-start-ap.patch \
	file://q02-050-wpa_supplicant-add-wpa_cli-support-for-cac.patch \
	file://q02-46-hostapd-Add-support-to-enable-disable-bss-color-coll.patch \
	file://q02-47-Changes-to-disable-compilation-errors-in-32-bit-arch.patch \
"

SRCREV = "b26f5c0fe35cd0472ea43f533b981ac2d91cdf1f"

FILES_${PN} += "/usr/sbin/*"

S = "${WORKDIR}/git"
inherit pkgconfig

DEPENDS = "libnl pkgconfig-native"
DEPENDS += "libubox"
DEPENDS += "openssl"

do_compile() {
	cp ${WORKDIR}/hostapd-mesh.config ${S}/${PKG_NAME}/.config
	sed -i '/CONFIG_UBUS=y/d' ${S}/${PKG_NAME}/.config
	sed -i '/CONFIG_INTERNAL_AES=y/d' ${S}/${PKG_NAME}/.config
	sed -i 's/CONFIG_TLS=internal/CONFIG_TLS=openssl/g' ${S}/${PKG_NAME}/.config
	cp ${WORKDIR}/wpa_supplicant-mesh.config ${S}/wpa_supplicant/.config
	sed -i '/CONFIG_TLS=internal/d' ${S}/wpa_supplicant/.config
	echo 'CONFIG_CTRL_IFACE_MIB=y' >> ${S}/wpa_supplicant/.config
	echo 'CONFIG_IEEE80211AX=y' >> ${S}/wpa_supplicant/.config
	make V=s  -C ${S}/${PKG_NAME}
	make V=s  -C ${S}/wpa_supplicant
}

do_install() {
	install -m 0755 -d ${D}/usr/sbin
	cp ${S}/${PKG_NAME}/hostapd ${D}/usr/sbin/
	cp ${S}/${PKG_NAME}/hostapd_cli ${D}/usr/sbin/
	cp ${S}/wpa_supplicant/wpa_supplicant ${D}/usr/sbin/
	cp ${S}/wpa_supplicant/wpa_cli ${D}/usr/sbin/
}
