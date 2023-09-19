@PayloadRoot(
localPart = "OperRequest", 
namespace = "http://www.abilashthomas.com/TestMgmt"
+ "/OperRequest")
@ResponsePayload
public Element OperDetails(
@RequestPayload Element OperRequestElement) {

return null	
}