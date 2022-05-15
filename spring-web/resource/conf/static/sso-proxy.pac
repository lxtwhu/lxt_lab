function FindProxyForURL(url, host) {
    if(!isPlainHostName(host) && localHostOrDomainIs(host,"techportal.oa.lxt.com")) {
        return "PROXY 172.21.224.247:50020";
    } else {
        return "DIRECT";
    }
}